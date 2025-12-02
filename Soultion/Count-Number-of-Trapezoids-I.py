1class Solution:
2    def countTrapezoids(self, points: List[List[int]]) -> int:
3        freq = Counter(p[1] for p in points)
4        sum, c2 = 0, 0
5        for f in freq.values():
6            if f <= 1:
7                continue
8            c = f * (f - 1) // 2
9            sum += c
10            c2 += c * c
11        return (sum * sum - c2) // 2 % (10**9 + 7)
12