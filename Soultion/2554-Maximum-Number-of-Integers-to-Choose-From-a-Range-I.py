class Solution:
    def maxCount(self, banned: List[int], n: int, maxSum: int) -> int:
        banned = set(banned)
        total, count = 0, 0
        for i in range(1, n+1):
            if i not in banned:
                if total + i > maxSum:
                    return count 
                total += i
                count += 1
        return count