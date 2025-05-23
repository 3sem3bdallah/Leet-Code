class Solution:
    def maximumValueSum(self, nums: List[int], k: int, edges: List[List[int]]) -> int:

        base_sum = sum(nums)
        gains = [(num ^ k) - num for num in nums]

        gains.sort(reverse=True)
        max_gain, current_gain, count = 0, 0, 0

        for gain in gains:
            current_gain += gain
            count += 1
            if count % 2 == 0:
                max_gain = max(max_gain, current_gain)

        return base_sum + max_gain