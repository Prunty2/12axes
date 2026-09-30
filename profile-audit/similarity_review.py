"""Evidence-bound review of close, but distinct, personality vectors.

Compatibility is not identity. Named people may share political positions. A
review acknowledges the overlap without changing answers to manufacture distance.
Reviews expire when either the audited answers or the neighbour's vector changes.
Exact duplicate vectors and other catalogues cannot use this review path.
"""
import hashlib
import json
from pathlib import Path


def fingerprint(value):
    canonical = json.dumps(value, sort_keys=True, ensure_ascii=False, separators=(",", ":"))
    return hashlib.sha256(canonical.encode("utf-8")).hexdigest()


def reviewed_neighbor(catalog, pid, neighbor, answers, vector, neighbor_vector, research_dir=None):
    if catalog != "personality" or vector == neighbor_vector:
        return None
    research_dir = research_dir or Path(__file__).parent / "research" / "personality"
    path = Path(research_dir) / f"{pid}.json"
    if not path.exists():
        return None
    research = json.loads(path.read_text(encoding="utf-8"))
    if research.get("id") != pid:
        return None
    sources = {s["id"] for s in research.get("sources", []) if s.get("url", "").startswith("https://")}
    for review in research.get("similarityReview", []):
        if (review.get("comparedWith") != neighbor
                or review.get("answersSha256") != fingerprint(answers)
                or review.get("neighborVectorSha256") != fingerprint(neighbor_vector)):
            continue
        reason = review.get("reason", "").strip()
        axes = review.get("differingAxes", [])
        refs = review.get("sourceIds", [])
        if (reason and axes and refs and set(refs) <= sources
                and all(a in vector and a in neighbor_vector and vector[a] != neighbor_vector[a]
                        for a in axes)):
            return reason
    return None
