import heapq
import math

class Solution:
    def pickGifts(self, gifts, k):

        gifts = [-gift for gift in gifts]
        heapq.heapify(gifts)
        
        for _ in range(k):
            largest = -heapq.heappop(gifts)
            heapq.heappush(gifts, -math.isqrt(largest))
        
        return -sum(gifts)
