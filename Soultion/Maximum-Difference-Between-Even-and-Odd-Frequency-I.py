class Solution:
    def maxDifference(self, s: str) -> int:
        cnt = Counter(s)

        odd_freqs = [freq for freq in cnt.values() if freq % 2 == 1]
        even_freqs = [freq for freq in cnt.values() if freq % 2 == 0]

        if not odd_freqs or not even_freqs:
                return 0
        return max(odd_freqs) - min(even_freqs)