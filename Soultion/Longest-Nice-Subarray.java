class Solution {
    public int longestNiceSubarray(int[] nums) {
        int left = 0, currentMask = 0, maxLen = 0;
        
        for (int right = 0; right < nums.length; right++) {
            // If conflict happens, shrink window
            while ((currentMask & nums[right]) != 0) {
                currentMask ^= nums[left]; // Remove nums[left] from mask
                left++; // Move left pointer
            }
            // Add nums[right] to mask
            currentMask |= nums[right];
            // Update maximum subarray length
            maxLen = Math.max(maxLen, right - left + 1);
        }
        
        return maxLen;
    }
}
