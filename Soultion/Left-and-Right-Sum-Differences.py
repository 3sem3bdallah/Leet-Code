1class Solution:
2    def leftRightDifference(self, nums: List[int]) -> List[int]:
3        n = len(nums)
4        res = [0] * n
5
6        for i in range(n):
7            left = sum(nums[:i])
8            right = sum(nums[i+1:])
9            res[i] = abs(left - right)
10
11        return res