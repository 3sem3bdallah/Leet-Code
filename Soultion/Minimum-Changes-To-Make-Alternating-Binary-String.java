1class Solution {
2    public int minOperations(String s) {
3        int start0 = 0;
4        int start1 = 0;
5
6        for (int i = 0; i < s.length(); i++) {
7
8            char expected0 = (i % 2 == 0) ? '0' : '1';
9            char expected1 = (i % 2 == 0) ? '1' : '0';
10
11            if (s.charAt(i) != expected0)
12                start0++;
13            if (s.charAt(i) != expected1)
14                start1++;
15        }
16        return Math.min(start0, start1);
17    }
18}