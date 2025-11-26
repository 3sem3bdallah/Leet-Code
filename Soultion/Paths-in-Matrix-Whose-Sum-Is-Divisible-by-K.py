1class Solution:
2    def numberOfPaths(self, grid: List[List[int]], k: int) -> int:
3        MOD = 10**9 + 7
4        m, n = len(grid), len(grid[0])
5
6        prev = [[0] * k for _ in range(n)]
7        curr = [[0] * k for _ in range(n)]
8
9        s = 0
10        for j in range(n):
11            s = (s + grid[0][j]) % k
12            prev[j][s] = 1
13
14        s = grid[0][0] % k
15
16        for i in range(1, m):
17            s = (s + grid[i][0]) % k
18            curr[0] = [0] * k
19            curr[0][s] = 1
20
21            for j in range(1, n):
22                curr[j] = [0] * k
23                val = grid[i][j]
24                for r in range(k):
25                    nr = (r + val) % k
26                    curr[j][nr] = (prev[j][r] + curr[j - 1][r]) % MOD
27
28            prev, curr = curr, prev
29
30        return prev[n - 1][0]
31