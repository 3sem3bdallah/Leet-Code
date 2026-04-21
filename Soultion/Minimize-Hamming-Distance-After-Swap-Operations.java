1class Solution {
2
3    class DSU {
4        int[] parent;
5
6        DSU(int n) {
7            parent = new int[n];
8            for (int i = 0; i < n; i++) {
9                parent[i] = i;
10            }
11        }
12
13        int find(int x) {
14            if (parent[x] != x) {
15                parent[x] = find(parent[x]); // path compression
16            }
17            return parent[x];
18        }
19
20        void union(int a, int b) {
21            int pa = find(a);
22            int pb = find(b);
23            if (pa != pb) {
24                parent[pb] = pa;
25            }
26        }
27    }
28
29    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
30        int n = source.length;
31
32        DSU dsu = new DSU(n);
33
34        // 1. build connections
35        for (int[] swap : allowedSwaps) {
36            dsu.union(swap[0], swap[1]);
37        }
38
39        // 2. group indices
40        Map<Integer, List<Integer>> groups = new HashMap<>();
41
42        for (int i = 0; i < n; i++) {
43            int root = dsu.find(i);
44            groups.computeIfAbsent(root, k -> new ArrayList<>()).add(i);
45        }
46
47        int res = 0;
48
49        // 3. process each group
50        for (List<Integer> indices : groups.values()) {
51
52            Map<Integer, Integer> count = new HashMap<>();
53
54            // count source values
55            for (int idx : indices) {
56                count.put(source[idx], count.getOrDefault(source[idx], 0) + 1);
57            }
58
59            // match target values
60            for (int idx : indices) {
61                int val = target[idx];
62
63                if (count.getOrDefault(val, 0) > 0) {
64                    count.put(val, count.get(val) - 1);
65                } else {
66                    res++; // mismatch
67                }
68            }
69        }
70
71        return res;
72    }
73}