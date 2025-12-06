1class Solution {
2    public int countPartitions(int[] nums, int k) {
3        int MOD = (int) 1e9 + 7, n = nums.length, left = 0;
4        int[] dp = new int[n + 1], prefix = new int[n + 2];
5
6        dp[0] = 1;
7        prefix[1] = 1;
8
9        Deque<Integer> min = new ArrayDeque<>(), max = new ArrayDeque<>();
10
11        for (int i = 0; i < n; i++) {
12            while (!max.isEmpty() && nums[max.peekLast()] <= nums[i]) {
13                max.pollLast();
14            }
15            max.addLast(i);
16
17            while (!min.isEmpty() && nums[min.peekLast()] >= nums[i]) {
18                min.pollLast();
19            }
20            min.addLast(i);
21
22            while (nums[max.peekFirst()] - nums[min.peekFirst()] > k) {
23                if (max.peekFirst() == left)
24                    max.pollFirst();
25                if (min.peekFirst() == left)
26                    min.pollFirst();
27
28                left++;
29            }
30
31            dp[i + 1] = (prefix[i + 1] - prefix[left] + MOD) % MOD;
32
33            prefix[i + 2] = (prefix[i + 1] + dp[i + 1]) % MOD;
34        }
35
36        return dp[n];
37    }
38}