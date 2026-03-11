1class Solution {
2    public int findComplement(int num) {
3        return (~num) & ((Integer.highestOneBit(num) << 1) - 1);
4    }
5}