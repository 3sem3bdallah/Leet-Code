class Solution:
    def minimumOperations(self, nums: List[int]) -> int:
        operations = 0

        while True:
            seen = set()
            duplicate_found = False

            for num in nums:
                if num in seen:
                    duplicate_found = True
                    break
                seen.add(num)

            if not duplicate_found:
                break

            nums = nums[3:]
            operations += 1

        return operations
