class Solution:
    def countSubarrays(self, nums: List[int], k: int) -> int:
        max_elem = max(nums)
        left, freq, count = 0, 0, 0
        for right in range(len(nums)):
            if nums[right] == max_elem:
                freq += 1
            while freq >= k:
                if nums[left] == max_elem:
                    freq -= 1
                left += 1
            count += left

        return count
