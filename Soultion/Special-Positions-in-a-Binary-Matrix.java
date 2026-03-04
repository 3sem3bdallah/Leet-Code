1class Solution {
2    public int numSpecial(int[][] mat) {
3        int m = mat.length;
4        int n = mat[0].length;
5
6        int[] row = new int[m];
7        int[] col = new int[n];
8
9        for (int i = 0; i < m; i++) {
10            for (int j = 0; j < n; j++) {
11                if (mat[i][j] == 1) {
12                    row[i]++;
13                    col[j]++;
14                }
15            }
16        }
17        int ans = 0;
18
19        for (int i = 0; i < m; i++) {
20            for (int j = 0; j < n; j++) {
21                if (mat[i][j] == 1 && row[i] == 1 && col[j] == 1){
22                    ans++;
23                }
24            }
25        }
26        return ans;
27    }
28}