1class Solution {
2
3    static class Node {
4        long cnt;
5        long sum;
6
7        Node(long cnt, long sum) {
8            this.cnt = cnt;
9            this.sum = sum;
10        }
11    }
12
13    String s;
14    Node[][][][] dp;
15    boolean[][][][] vis;
16
17    public Node dfs(int pos, int prev1, int prev2,
18            int started, boolean tight) {
19
20        if (pos == s.length()) {
21            return new Node(1, 0);
22        }
23
24        if (!tight && vis[pos][prev1][prev2][started]) {
25            return dp[pos][prev1][prev2][started];
26        }
27
28        int limit = tight ? s.charAt(pos) - '0' : 9;
29
30        long ways = 0;
31        long waviness = 0;
32
33        for (int d = 0; d <= limit; d++) {
34
35            boolean ntight = tight && d == limit;
36
37            if (started == 0 && d == 0) {
38
39                Node child = dfs(pos + 1, 10, 10, 0, ntight);
40
41                ways += child.cnt;
42                waviness += child.sum;
43            } else if (started == 0) {
44
45                Node child = dfs(pos + 1, d, 10, 1, ntight);
46
47                ways += child.cnt;
48                waviness += child.sum;
49            } else if (prev2 == 10) {
50
51                Node child = dfs(pos + 1, d, prev1, 1, ntight);
52
53                ways += child.cnt;
54                waviness += child.sum;
55            } else {
56
57                int add = ((prev1 > prev2 && prev1 > d) ||
58                        (prev1 < prev2 && prev1 < d))
59                                ? 1
60                                : 0;
61
62                Node child = dfs(pos + 1, d, prev1, 1, ntight);
63
64                ways += child.cnt;
65                waviness += child.sum + add * child.cnt;
66            }
67        }
68
69        Node res = new Node(ways, waviness);
70
71        if (!tight) {
72            vis[pos][prev1][prev2][started] = true;
73            dp[pos][prev1][prev2][started] = res;
74        }
75
76        return res;
77    }
78
79    public long solve(long x) {
80        if (x < 0)
81            return 0;
82
83        s = Long.toString(x);
84
85        dp = new Node[20][11][11][2];
86        vis = new boolean[20][11][11][2];
87
88        return dfs(0, 10, 10, 0, true).sum;
89    }
90
91    public int totalWaviness(int num1, int num2) {
92        return (int) (solve(num2) - solve(num1 - 1L));
93    }
94}