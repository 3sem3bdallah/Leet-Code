1class Solution {
2    public String findDifferentBinaryString(String[] nums) {
3        int n = nums.length;
4        StringBuilder ans = new StringBuilder();
5
6        for (int i = 0; i < n; i++) {
7            if (nums[i].charAt(i) == '0') {
8                ans.append('1');
9            } else {
10                ans.append('0');
11            }
12        }
13
14        return ans.toString();
15    }
16}