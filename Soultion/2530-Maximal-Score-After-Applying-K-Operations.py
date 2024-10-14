import heapq
import math
class Solution:
    def maxKelements(self, nums: List[int], k: int) -> int:
     
        max_heap = [-num for num in nums]
        heapq.heapify(max_heap)
        
        score = 0
        
        for _ in range(k):
            largest = -heapq.heappop(max_heap)
            score += largest
            new_value = math.ceil(largest / 3)
            heapq.heappush(max_heap, -new_value)
        
        return score
