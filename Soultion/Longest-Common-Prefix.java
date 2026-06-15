1class Solution {
2    public String longestCommonPrefix(String[] strs) {
3        String prefix = strs[0];
4        int n = strs.length;
5        for (int i = 1; i < n; i++) {
6            while (!strs[i].startsWith(prefix)) {
7                prefix = prefix.substring(0, prefix.length() - 1);
8            }
9        }
10        return prefix;
11    }
12}