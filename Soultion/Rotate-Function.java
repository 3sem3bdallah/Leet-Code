1class Solution {
2    public int maxRotateFunction(int[] nums) {
3        int n = nums.length;
4        int sum = 0;
5        int f0 = 0;
6
7        for (int i = 0; i < n; i++) {
8            sum += nums[i];
9            f0 += i * nums[i];
10        }
11
12        int max = f0;
13        int current = f0;
14
15        for (int k = 1; k < n; k++) {
16            current = current + sum - n * nums[n - k];
17            max = Math.max(max, current);
18        }
19
20        return max;
21    }
22}