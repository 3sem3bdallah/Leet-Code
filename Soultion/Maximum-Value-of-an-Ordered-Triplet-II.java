class Solution {
    public long maximumTripletValue(int[] nums) {
        long[] preMax = new long[nums.length];
        long[] postMax = new long[nums.length];

        for (int i = 1; i < nums.length; i++) {
            preMax[i] = Math.max(preMax[i - 1], nums[i - 1]);
        }
        for (int i = nums.length - 2; i > 0; i--) {
            postMax[i] = Math.max(postMax[i + 1], nums[i + 1]);
        }
        long result = 0;
        for (int i = 1; i < nums.length; i++) {
            result = Math.max(result, (preMax[i] - nums[i]) * postMax[i]);
        }
        return result;
    }
}