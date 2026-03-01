1class Solution {
2    public int minPartitions(String n) {
3        int maxDigit = 0;
4
5        for (int i = 0; i < n.length(); i++) {
6            int digit = n.charAt(i) - '0';
7            maxDigit = Math.max(maxDigit, digit);
8
9            if (maxDigit == 9) {
10                return 9;
11            }
12        }
13
14        return maxDigit;
15    }
16}