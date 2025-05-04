class Solution:
    def numEquivDominoPairs(self, dominoes: List[List[int]]) -> int:
        normalized = [tuple(sorted(domino)) for domino in dominoes]
        count = Counter(normalized)
        
        res = 0
        for val in count.values():
            res += val * (val - 1) // 2
        return res
