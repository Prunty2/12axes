import json
from pathlib import Path
import tempfile
import unittest

from similarity_review import fingerprint, reviewed_neighbor


class SimilarityReviewTest(unittest.TestCase):
    def setUp(self):
        self.directory = tempfile.TemporaryDirectory()
        self.addCleanup(self.directory.cleanup)
        self.answers = {"estrutura": {"answers": {"estrutura_01": "C"}}}
        self.vector = {"estrutura": 39.0}
        self.neighbor = {"estrutura": 56.2}
        self.record = {
            "id": "person-a",
            "sources": [{"id": "speech", "url": "https://example.org/speech"}],
            "similarityReview": [{
                "comparedWith": "person-b",
                "answersSha256": fingerprint(self.answers),
                "neighborVectorSha256": fingerprint(self.neighbor),
                "reason": "Different national and state responsibilities, supported by the cited speech.",
                "differingAxes": ["estrutura"],
                "sourceIds": ["speech"],
            }],
        }

    def check_review(self, catalog="personality", neighbor_id="person-b"):
        Path(self.directory.name, "person-a.json").write_text(json.dumps(self.record))
        return reviewed_neighbor(catalog, "person-a", neighbor_id, self.answers, self.vector,
                                 self.neighbor, self.directory.name)

    def test_current_sourced_review_accepts_distinct_people(self):
        self.assertTrue(self.check_review())

    def test_changed_answers_or_neighbor_require_new_review(self):
        self.answers["estrutura"]["answers"]["estrutura_01"] = "D"
        self.assertIsNone(self.check_review())
        self.record["similarityReview"][0]["answersSha256"] = fingerprint(self.answers)
        self.neighbor["estrutura"] = 60.0
        self.assertIsNone(self.check_review())

    def test_exact_duplicate_cannot_be_reviewed_away(self):
        self.vector = dict(self.neighbor)
        self.assertIsNone(self.check_review())

    def test_other_catalogues_and_other_neighbors_are_not_exempt(self):
        self.assertIsNone(self.check_review(catalog="ideology"))
        self.assertIsNone(self.check_review(catalog="country"))
        self.assertIsNone(self.check_review(neighbor_id="person-c"))

    def test_missing_evidence_or_false_axis_difference_is_rejected(self):
        self.record["similarityReview"][0]["sourceIds"] = ["absent"]
        self.assertIsNone(self.check_review())
        self.record["similarityReview"][0]["sourceIds"] = ["speech"]
        self.record["similarityReview"][0]["differingAxes"] = ["missing"]
        self.assertIsNone(self.check_review())

    def test_missing_review_is_rejected(self):
        self.record["similarityReview"] = []
        self.assertIsNone(self.check_review())


if __name__ == "__main__":
    unittest.main()
