class Solution {
    public int minimumIndex(List<Integer> nums) {

        // Get the dominant element in the array
        int dominantElement = getDominantElement(nums);

        int firstArrayCount = 0; // Count of dominant element in the first array
        int splitIndex = -1; // This is the minimum index of a valid split
        int count = 0; // Count of dominant element in the whole array
        boolean flag = false; // A flag to make sure we update the split index only once (since we want
                              // minimum index)
        for (int i = 0; i < nums.size(); i++) {
            int firstArrayLength = i + 1; // Length of the first array
            if (nums.get(i) == dominantElement) {
                count++; // Increment the count of dominant element
            }

            // Check if the dominant element is ALSO dominant element in the first array
            if (!flag && count > firstArrayLength / 2) {
                // This means first array has the dominant element
                firstArrayCount = count;
                splitIndex = i;
                flag = true;
            }
        }

        // Now we need to check if the dominant element is ALSO dominant element in the
        // second array
        int secondArrayLength = nums.size() - (splitIndex + 1); // Length of the second array
        int remCount = count - firstArrayCount; // Count of dominant element in the remaining array i.e. second array

        // Check if the dominant element is ALSO dominant element in the second array
        if (remCount > secondArrayLength / 2)
            return splitIndex; // If yes, then return the minimum index of the valid split
        else
            return -1; // Else, return -1
    }

    /*
     * Below function gives us the dominant element in the array in
     * TC: O(n) and SC: O(1)
     */
    private int getDominantElement(List<Integer> nums) {
        int ele = nums.get(0), count = 1, maxEle = -1, maxCount = -1;

        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) != ele) {
                if (count > maxCount) {
                    maxCount = count;
                    maxEle = ele;
                }
                ele = nums.get(i);
                count = 1;
            } else {
                count++;
            }
        }

        if (count > maxCount) {
            maxCount = count;
            maxEle = ele;
        }

        return maxEle;
    }
}