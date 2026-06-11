1class Solution:
2    def assignEdgeWeights(self, edges: List[List[int]]) -> int:
3        mod = 1_000_000_007
4        n = len(edges) + 1
5        graph = [[] for _ in range(n + 1)]
6        for u, v in edges:
7            graph[u].append(v)
8            graph[v].append(u)
9
10        def dfs(node: int, prev: int) -> int:
11            d = 0
12            for c in graph[node]:
13                if c != prev:
14                    d = max(d, dfs(c, node) + 1)
15            return d
16
17        return pow(2, dfs(1, 0) - 1, mod)