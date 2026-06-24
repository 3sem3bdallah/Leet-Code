1class NumMatrix {
2public:
3    vector<vector<int>> ans;
4
5    NumMatrix(vector<vector<int>>& matrix) {
6        int n = matrix.size();
7        int m = matrix[0].size();
8
9        ans.resize(n, vector<int>(m));
10
11        ans[0][0] = matrix[0][0];
12
13        for (int j = 1; j < m; j++) {
14            ans[0][j] = ans[0][j - 1] + matrix[0][j];
15        }
16
17        for (int i = 1; i < n; i++) {
18            ans[i][0] = ans[i - 1][0] + matrix[i][0];
19        }
20
21        for (int i = 1; i < n; i++) {
22            for (int j = 1; j < m; j++) {
23                ans[i][j] = matrix[i][j]
24                          + ans[i - 1][j]
25                          + ans[i][j - 1]
26                          - ans[i - 1][j - 1];
27            }
28        }
29    }
30
31    int sumRegion(int row1, int col1, int row2, int col2) {
32        int res = ans[row2][col2];
33
34        if (row1 > 0)
35            res -= ans[row1 - 1][col2];
36
37        if (col1 > 0)
38            res -= ans[row2][col1 - 1];
39
40        if (row1 > 0 && col1 > 0)
41            res += ans[row1 - 1][col1 - 1];
42
43        return res;
44    }
45};