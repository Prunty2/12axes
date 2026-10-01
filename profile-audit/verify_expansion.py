"""Check the international expansion against its full recorded scope.

Run from any directory. --require-complete additionally rejects unfinished
candidate reviews and missing explicitly requested Australian personalities.
This verifies data integrity, not the truth of editorial political judgements.
"""
import argparse
import hashlib
import json
from pathlib import Path

from profile_vector import AXIS_ORDER, SCORE, archetype_problems, compute_vector, question_map

ROOT = Path(__file__).resolve().parents[1]
DATA = ROOT / "backend/src/main/resources/data"


def read(path):
    return json.loads(path.read_text(encoding="utf-8"))


def unique_map(entries, key):
    result = {e[key]: e for e in entries}
    assert len(result) == len(entries), f"Duplicate {key}"
    return result


def verify(require_complete=False):
    state = read(ROOT / "profile-audit/STATE.json")["personality"]
    expansion = state["expansion"]
    candidates = unique_map(expansion["candidates"], "id")
    pt = unique_map(read(DATA / "personalities.json"), "id")
    en = unique_map(read(DATA / "i18n/en/personalities.json"), "id")
    profiles = unique_map(read(DATA / "personality-profiles.json"), "personalityId")
    assert set(pt) == set(en) == set(profiles), "Catalogue, translation and vector IDs differ"
    assert state["totalProfiles"] == len(pt), "Stale totalProfiles"
    assert len(state["done"]) == len(set(state["done"])), "Duplicate done IDs"
    qmap = question_map()
    completed = []
    for pid, candidate in candidates.items():
        status = candidate["status"]
        assert status in {"pending", "added", "skipped"}, (pid, status)
        if status == "skipped":
            assert candidate.get("reason") and candidate.get("checkedSources"), f"Undocumented skip: {pid}"
        if status != "added":
            assert pid not in pt, f"Unfinished candidate leaked into catalogue: {pid}"
            continue
        assert pid in pt and pid in state["done"], f"Missing completed profile: {pid}"
        assert pt[pid]["category"] == "politico", pid
        for record in [pt[pid], en[pid]]:
            assert all(record.get(k) for k in ["id", "name", "role", "description"]), pid
            assert len(record["description"]) <= 280 and len(record["description"].split()) <= 45, pid
        for key in ["lifespan", "imagePath", "imageSourceName", "imageSourceUrl", "imageNote"]:
            assert pt[pid].get(key), (pid, key)
        portrait = ROOT / "frontend/public" / pt[pid]["imagePath"].lstrip("/")
        assert portrait.is_file() and portrait.stat().st_size > 0, f"Missing portrait: {pid}"
        review = expansion.get("processReview", {})
        archive_name = review.get("activeAnswerArchives", {}).get(
            pid, f"profile-audit/answers/personality/{pid}.json")
        archive_path = (ROOT / archive_name).resolve()
        assert archive_path.is_relative_to(ROOT / "profile-audit/answers/personality"), pid
        answers = read(archive_path)
        original_hash = review.get("originalAnswerSha256", {}).get(pid)
        if original_hash:
            original = ROOT / f"profile-audit/answers/personality/{pid}.json"
            assert hashlib.sha256(original.read_bytes()).hexdigest() == original_hash, (
                f"Permanent original answers changed: {pid}")
        assert set(answers) == set(AXIS_ORDER) | {"archetype"}, pid
        assert not archetype_problems(answers), pid
        for axis in AXIS_ORDER:
            assert answers[axis]["personaBrief"].strip(), (pid, axis)
            expected = {qid for qid, q in qmap.items() if q["axisId"] == axis}
            assert set(answers[axis]["answers"]) == expected, (pid, axis)
            assert set(answers[axis]["answers"].values()) <= set(SCORE), (pid, axis)
        assert compute_vector(answers, qmap) == profiles[pid]["vector"], f"Vector differs from archive: {pid}"
        research = read(ROOT / f"profile-audit/research/personality/{pid}.json")
        assert research["id"] == pid and research["country"] == candidate["country"], pid
        assert research.get("researchedOn") and research.get("profilePeriod") and research.get("scopeNote"), pid
        sources = unique_map(research["sources"], "id")
        assert len({s["url"] for s in sources.values()}) >= 3, f"Insufficient sources: {pid}"
        for source in sources.values():
            assert all(source.get(k) for k in ["title", "url", "factDate", "accessedOn"]), pid
        assert set(research["axes"]) == set(AXIS_ORDER), f"Missing axis research: {pid}"
        for axis in AXIS_ORDER:
            refs = research["axes"][axis]["sourceIds"]
            assert refs and set(refs) <= set(sources), (pid, axis)
        assert research["portrait"]["visuallyChecked"] is True, f"Portrait not checked: {pid}"
        completed.append(pid)
    pending = [pid for pid, c in candidates.items() if c["status"] == "pending"]
    skipped = [pid for pid, c in candidates.items() if c["status"] == "skipped"]
    if require_complete:
        process_review = expansion.get("processReview", {})
        if process_review:
            assert process_review.get("status") == "complete", "Process compliance review is unfinished"
            assert not process_review.get("pending"), "Independent reviews remain pending"
            assert set(completed) <= set(process_review.get("reviewed", [])), "Missing independent review"
            runs = process_review.get("runs", {})
            assert all(runs.get(pid, {}).get("status") == "merged" for pid in completed), "Unmerged independent answers"
            agents = [runs[pid].get("agent") for pid in completed]
            assert all(agents) and len(set(agents)) == len(agents), "Each profile needs its own independent agent"
            assert set(completed) <= set(process_review.get("activeAnswerArchives", {})), "Missing revised archive"
        assert not pending, f"{len(pending)} candidates remain; next: {pending[:5]}"
        assert set(expansion["requiredAustralianIds"]) <= set(completed), "Requested Australians missing"
    return {"added": len(completed), "pending": len(pending), "skipped": len(skipped),
            "planned": len(candidates), "catalogueTotal": len(pt)}


if __name__ == "__main__":
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("--require-complete", action="store_true")
    args = parser.parse_args()
    print(json.dumps(verify(args.require_complete), indent=2))
