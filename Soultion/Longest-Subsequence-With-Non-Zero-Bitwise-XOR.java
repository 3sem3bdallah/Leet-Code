class Solution {
    public int longestSubsequence(int[] nums) {
       int totalXor = 0;
        boolean allZero = true;

        for (int num : nums) {
            totalXor ^= num;
            if (num != 0) allZero = false;
        }

        if (allZero) return 0;
        return totalXor != 0 ? nums.length : nums.length - 1;
    }
}
