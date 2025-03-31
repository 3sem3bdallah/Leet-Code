from heapq import heappush, heappop


class Solution:
    def putMarbles(self, weights: List[int], k: int) -> int:

        totalWeights = len(weights)
        maxHeap, minHeap = [], []
        maxScore, minScore = 0, 0
        for index in range(totalWeights - 1):
            pairSum = weights[index] + weights[index + 1]
            heappush(maxHeap, -pairSum)
            heappush(minHeap, pairSum)
        for split in range(k - 1):
            maxScore += -heappop(maxHeap)
            minScore += heappop(minHeap)
        return maxScore - minScore
