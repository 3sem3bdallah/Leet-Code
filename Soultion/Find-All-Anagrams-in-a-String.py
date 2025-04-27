class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        n, m = len(s), len(p)
        if n < m:
            return []

        p_count = [0] * 26
        window_count = [0] * 26

        for char in p:
            p_count[ord(char) - ord(\a\)] += 1

        res = []

        for i in range(m):
            window_count[ord(s[i]) - ord(\a\)] += 1

        if window_count == p_count:
            res.append(0)

        for i in range(m, n):
            window_count[ord(s[i]) - ord(\a\)] += 1
            window_count[ord(s[i - m]) - ord(\a\)] -= 1

            if window_count == p_count:
                res.append(i - m + 1)

        return res
