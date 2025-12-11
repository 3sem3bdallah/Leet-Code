1class Solution:
2    def countCoveredBuildings(self, n: int, b: List[List[int]]) -> int:
3        rmax = [0] * (n + 1)
4        rmin = [n + 1] * (n + 1)
5        cmax = [0] * (n + 1)
6        cmin = [n + 1] * (n + 1)
7
8        # Track extreme buildings for each row and column
9        for x, y in b:
10            rmax[y] = max(rmax[y], x)
11            rmin[y] = min(rmin[y], x)
12            cmax[x] = max(cmax[x], y)
13            cmin[x] = min(cmin[x], y)
14
15        ans = 0
16
17        # A building is covered only if it's strictly inside both extremes
18        for x, y in b:
19            if rmin[y] < x < rmax[y] and cmin[x] < y < cmax[x]:
20                ans += 1
21
22        return ans