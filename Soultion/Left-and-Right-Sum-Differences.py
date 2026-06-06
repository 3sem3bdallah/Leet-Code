1class Solution:
2    def leftRightDifference(self, nums: List[int]) -> List[int]:
3        total = sum(nums)
4        left = 0
5        ans = []
6
7        for x in nums:
8            total -= x       # right sum
9            ans.append(abs(left - total))
10            left += x
11
12        return ans