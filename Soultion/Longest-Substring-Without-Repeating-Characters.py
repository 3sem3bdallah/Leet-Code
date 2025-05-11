class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        seen = []
        res = 0

        for ch in s:
            if ch in seen:
                idx = seen.index(ch)
                seen = seen[idx + 1:]
            seen.append(ch)
            res = max(res, len(seen))

        return res
