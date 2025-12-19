1class Solution:
2    def dfs(self, x, adj, vis):
3        vis[x] = True
4        for nei in adj.get(x, []):
5            if not vis[nei]:
6                self.dfs(nei, adj, vis)
7
8    def findAllPeople(self, n: int, meetings: list[list[int]], firstPerson: int) -> list[int]:
9        ans = []
10        vis = [False] * n
11        vis[0] = True
12        vis[firstPerson] = True
13
14        meetings.sort(key=lambda a: a[2])
15        i = 0
16
17        while i < len(meetings):
18            time = meetings[i][2]
19            adj = {}
20            secret = set()
21
22            while i < len(meetings) and meetings[i][2] == time:
23                x, y = meetings[i][0], meetings[i][1]
24
25                if x not in adj:
26                    adj[x] = []
27                if y not in adj:
28                    adj[y] = []
29
30                adj[x].append(y)
31                adj[y].append(x)
32
33                if vis[x]:
34                    secret.add(x)
35                if vis[y]:
36                    secret.add(y)
37
38                i += 1
39
40            for s in secret:
41                self.dfs(s, adj, vis)
42
43        for j in range(n):
44            if vis[j]:
45                ans.append(j)
46
47        return ans