1class Solution {
2    public long maxSubarraySum(int[] nums, int k) {
3        final long n = nums.length, INF = Long.MAX_VALUE / 2;
4        long[] minS = new long[k];
5        for (int i = 0; i < k - 1; i++)
6            minS[i] = INF;
7        minS[k - 1] = 0;
8        long prefix = 0, ans = -INF;
9        for (int i = 0; i < n; i++) {
10            prefix += nums[i];
11            int ik = i % k;
12            ans = Math.max(ans, prefix - minS[ik]);
13            minS[ik] = Math.min(prefix, minS[ik]);
14        }
15        return ans;
16    }
17}