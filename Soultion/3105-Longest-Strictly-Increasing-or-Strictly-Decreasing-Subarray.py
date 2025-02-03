class Solution:
    def longestMonotonicSubarray(self, nums: List[int]) -> int:
        longest = 1
        inc_count = 1
        dec_count = 1

        for i in range(1, len(nums)):
            if nums[i] > nums[i - 1]:  
                inc_count += 1
                dec_count = 1  
            elif nums[i] < nums[i - 1]:  
                dec_count += 1
                inc_count = 1   
            else:
                inc_count = 1
                dec_count = 1

            longest = max(longest, inc_count, dec_count)

        return longest
