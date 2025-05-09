class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long ans = 0;
        int minPosition = -1;
        int maxPosition = -1;
        int leftBound = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minK || nums[i] > maxK) {
                leftBound = i;
            }

            if (nums[i] == minK) {
                minPosition = i;
            }
            if (nums[i] == maxK) {
                maxPosition = i;
            }

            ans += Math.max(0, Math.min(minPosition, maxPosition) - leftBound);
        }

        return ans;
    }
}