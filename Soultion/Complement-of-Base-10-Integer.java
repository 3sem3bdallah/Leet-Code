1class Solution {
2    public int bitwiseComplement(int n) {
3        if (n == 0) return 1;
4        int mask = (1 << (32 - Integer.numberOfLeadingZeros(n))) - 1;
5        return n ^ mask;
6    }
7}