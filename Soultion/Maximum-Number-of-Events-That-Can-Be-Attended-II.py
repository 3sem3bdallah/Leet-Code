class Solution:
    def maxValue(self, events: List[List[int]], k: int) -> int:
        N = len(events)
        events.sort()

        memo = [[-1 for _ in range(k+1)] for _ in range(N)]
        def max_events_recur(idx, k):
            if idx == N or k == 0:
                return 0
            
            if memo[idx][k] != -1:
                return memo[idx][k]
            
            startDay, endDay, value = events[idx]
            

            nextIdxAvail = bisect.bisect_right(events, endDay, key=lambda event: event[0])
            total = value + max_events_recur(nextIdxAvail, k-1)

            total = max(total, max_events_recur(idx+1, k))

            memo[idx][k] = total
            return total

        total =  max_events_recur(0, k)

        return total