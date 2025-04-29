class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        def is_valid(length):
            total = sum(nums[:length])
            if total >= target:
                return True
            for i in range(length, len(nums)):
                total += nums[i] - nums[i - length]
                if total >= target:
                    return True
            return False

        left, right = 1, len(nums)
        ans = 0

        while left <= right:
            mid = (left + right) // 2
            if is_valid(mid):
                ans = mid
                right = mid - 1
            else:
                left = mid + 1

        return ans
