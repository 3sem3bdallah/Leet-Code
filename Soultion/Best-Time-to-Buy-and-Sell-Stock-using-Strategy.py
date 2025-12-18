1class Solution:
2    def maxProfit(self, prices: List[int], strategy: List[int], k: int) -> int:
3        n, h = len(prices), k >> 1
4        base = prev = nxt = best = 0
5
6        for i in range(n):
7            base += strategy[i] * prices[i]
8
9        for i in range(k):
10            prev += strategy[i] * prices[i]
11            if i >= h:
12                nxt += prices[i]
13
14        best = max(0, nxt - prev)
15
16        for r in range(k, n):
17            l = r - k + 1
18            prev += strategy[r] * prices[r] - strategy[l - 1] * prices[l - 1]
19            nxt += prices[r] - prices[l - 1 + h]
20            best = max(best, nxt - prev)
21
22        return base + best