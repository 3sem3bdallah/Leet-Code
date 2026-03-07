1class Solution {
2    public int minFlips(String s) {
3        int n = s.length();
4        String ss = s + s;
5
6        int diff1 = 0;
7        int diff2 = 0;
8        int res = Integer.MAX_VALUE;
9
10        for (int i = 0; i < ss.length(); i++) {
11
12            char expected1 = (i % 2 == 0) ? '0' : '1';
13            char expected2 = (i % 2 == 0) ? '1' : '0';
14
15            if (ss.charAt(i) != expected1) diff1++;
16            if (ss.charAt(i) != expected2) diff2++;
17
18            if (i >= n) {
19                char prev1 = ((i - n) % 2 == 0) ? '0' : '1';
20                char prev2 = ((i - n) % 2 == 0) ? '1' : '0';
21
22                if (ss.charAt(i - n) != prev1) diff1--;
23                if (ss.charAt(i - n) != prev2) diff2--;
24            }
25
26            if (i >= n - 1) {
27                res = Math.min(res, Math.min(diff1, diff2));
28            }
29        }
30
31        return res;
32    }
33}