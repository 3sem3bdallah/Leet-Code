1class Solution {
2    public int minDeletionSize(String[] strs) {
3        int count = 0;
4        int n = strs.length;
5        int m = strs[0].length();
6
7        for (int i = 0; i < m; i++) {
8            for (int j = 0; j < n - 1; j++) {
9                if (strs[j].charAt(i) > strs[j + 1].charAt(i)) {
10                    count++;
11                    break;
12                }
13            }
14        }
15        return count;
16    }
17}
18