class Solution:
    def maxIncreasingSubarrays(self, nums):
        pre = ans = 0
        suff = 1
        for i in range(1, len(nums)):
            if nums[i] > nums[i - 1]:
                suff += 1
            else:
                pre, suff = suff, 1
            ans = max(ans, suff // 2, min(pre, suff))
        return ans
