class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        nums = sorted(set(nums))

        if not nums:
            return 0

        current = 1
        best = 1

        for i in range(1, len(nums)):
            if nums[i] - nums[i - 1] == 1:
                current += 1
            else:
                best = max(best, current)
                current = 1

        best = max(best, current)

        return best