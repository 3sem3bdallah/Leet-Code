class Solution:
    def countInterestingSubarrays(self, nums: List[int], modulo: int, k: int) -> int:
        ans = prefix = 0
        counts = defaultdict(int)
        counts[0] = 1
        for num in nums:
            if num % modulo == k:
                prefix += 1
            ans += counts[(prefix - k + modulo) % modulo]
            counts[prefix % modulo] += 1
        return ans
