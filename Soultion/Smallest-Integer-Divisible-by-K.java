1class Solution {
2    public int smallestRepunitDivByK(int k) {
3        int rem = 0;
4        for (int len = 1; len <= k; len++) {
5            rem = (rem * 10 + 1) % k;
6            if (rem == 0)
7                return len;
8        }
9        return -1;
10    }
11}