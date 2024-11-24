class Solution:
    def maxMatrixSum(self, matrix: List[List[int]]) -> int:
        
        res = neg_count = 0
        mat_min = float("inf")
        for row in matrix:
            for n in row:
                res += abs(n)
                mat_min = min(mat_min, abs(n))
                if n < 0:
                    neg_count += 1
        if neg_count & 1:
            res -= 2 * mat_min

        return res