1class Solution:
2    def minDeletionSize(self, strs):
3        n, m = len(strs), len(strs[0])
4        sorted_pairs = [False] * (n - 1)
5        delCount = 0
6
7        for col in range(m):
8            bad = False
9            for i in range(n - 1):
10                if not sorted_pairs[i] and strs[i][col] > strs[i + 1][col]:
11                    bad = True
12                    break
13
14            if bad:
15                delCount += 1
16                continue
17
18            for i in range(n - 1):
19                if not sorted_pairs[i] and strs[i][col] < strs[i + 1][col]:
20                    sorted_pairs[i] = True
21
22            if all(sorted_pairs):
23                break
24
25        return delCount