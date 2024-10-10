class Solution:
    def maxWidthRamp(self, nums: List[int]) -> int:

        indexed_nums = [(value, index) for index, value in enumerate(nums)]

        indexed_nums.sort()
        
        max_width = 0
        min_index = float('inf')
        
        for value, index in indexed_nums:

            min_index = min(min_index, index)

            max_width = max(max_width, index - min_index)
        
        return max_width
