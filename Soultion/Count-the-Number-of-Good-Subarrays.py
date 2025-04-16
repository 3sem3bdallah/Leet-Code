class Solution:
    def countGood(self, nums: List[int], k: int) -> int:

        cnts = defaultdict(int)

        n = len(nums)
        l = 0
        pairs = 0
        res = 0

        for r in range(n):
            cnts[nums[r]] += 1
            pairs += cnts[nums[r]] - 1

            while pairs >= k:
                res += n - r

                cnts[nums[l]] -= 1
                pairs -= cnts[nums[l]]
                l += 1

        return res
