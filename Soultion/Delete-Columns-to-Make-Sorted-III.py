1class Solution(object):
2    def minDeletionSize(self, strs):
3        n = len(strs[0])
4        m = len(strs)
5        dp = [1] * n
6
7        for i in range(1, n):
8            for j in range(i):
9                ok = True
10                for r in range(m):
11                    if strs[r][j] > strs[r][i]:
12                        ok = False
13                        break
14                if ok:
15                    dp[i] = max(dp[i], dp[j] + 1)
16
17        mx = 0
18        for v in dp:
19            mx = max(mx, v)
20        return n - mx