1class Solution {
2    public int minimumCost(int[] cost) {
3        Arrays.sort(cost);
4        int res = 0;
5        int len = cost.length;
6
7        for (int i = 0; i < len; i += 3) {
8            res += cost[len - i - 1];
9            if (i + 1 < len)
10                res += cost[len - 1 - (i + 1)];
11        }
12        return res;
13    }
14}