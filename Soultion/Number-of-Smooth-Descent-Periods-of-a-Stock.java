1class Solution {
2    static public long getDescentPeriods(int[] prices) {
3        long sum = 0, des = 0;
4        int prev = -1;
5        for (int x : prices) {
6            des = (x + 1 == prev ? des : 0) + 1;
7            sum += des;
8            prev = x;
9        }
10        return sum;
11    }
12}