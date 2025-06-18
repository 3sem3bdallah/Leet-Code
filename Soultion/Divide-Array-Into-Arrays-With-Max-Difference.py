class Solution:
    def divideArray(self, nums: List[int], k: int) -> List[List[int]]:
        heapq.heapify(nums)
        res = []

        while len(nums) >= 3:
            low = heapq.heappop(nums)
            mid = heapq.heappop(nums)
            high = heapq.heappop(nums)

            if high - low <= k:
                res.append([low, mid, high])
            else:
                return []

        return res