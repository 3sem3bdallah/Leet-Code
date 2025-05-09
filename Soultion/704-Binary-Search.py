class Solution:
    def search(self, nums: List[int], target: int) -> int:
        n = len(nums)
        l, h = 0, n-1
        while l <= h:
            mid = (l + h) // 2
            if target > nums[mid]:
                l = mid + 1
            elif target < nums[mid]:
                h = mid -1
            else:
                return mid
        return-1
