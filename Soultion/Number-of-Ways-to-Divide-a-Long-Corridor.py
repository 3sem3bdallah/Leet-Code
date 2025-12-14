1class Solution(object):
2    def numberOfWays(self, corridor):
3        mod = 10**9 + 7
4        pos = []
5
6        for i, c in enumerate(corridor):
7            if c == 'S':
8                pos.append(i)
9
10        if len(pos) % 2 == 1 or len(pos) == 0:
11            return 0
12
13        res = 1
14        for i in range(2, len(pos), 2):
15            len_of_gap = pos[i] - pos[i - 1]
16            res = (res * len_of_gap) % mod
17
18        return res