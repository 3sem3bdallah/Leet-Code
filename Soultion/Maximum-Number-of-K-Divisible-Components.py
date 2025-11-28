1class Solution(object):
2    def maxKDivisibleComponents(self, n, edges, values, k):
3        adj = [[] for _ in range(n)]
4        for a, b in edges:
5            adj[a].append(b)
6            adj[b].append(a)
7
8        self.ans = 0
9
10        def dfs(node, parent):
11            s = values[node]
12            for nxt in adj[node]:
13                if nxt != parent:
14                    s += dfs(nxt, node)
15            if s % k == 0:
16                self.ans += 1
17            return s % k
18
19        dfs(0, -1)
20        return self.ans