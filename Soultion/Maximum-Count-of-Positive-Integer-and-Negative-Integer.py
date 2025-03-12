class Solution:
    def maximumCount(self, nums: List[int]) -> int:
        
        pos = len(nums) - bisect_left(nums, 1)
        neg = bisect_left(nums, 0)
        
        return max(pos, neg)