class Solution:
    def countBadPairs(self, nums):
        count = 0
        freq_map = defaultdict(int)

        for i, num in enumerate(nums):

            key = num - i
            count += freq_map[key]
            freq_map[key] += 1

        total_pairs = len(nums) * (len(nums) - 1) // 2
        
        return total_pairs - count
