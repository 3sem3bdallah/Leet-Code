class Solution {
    public int maxAbsoluteSum(int[] nums) {
         int maxSum = 0, minSum = 0, currentMax = 0, currentMin = 0;
        int maxAbsSum = 0;

        for (int x : nums) {
            currentMax += x;
            currentMin += x;

            if (currentMax < 0) currentMax = 0;
            if (currentMin > 0) currentMin = 0;

            maxSum = Math.max(maxSum, currentMax);
            minSum = Math.min(minSum, currentMin);

            maxAbsSum = Math.max(maxAbsSum, Math.max( Math.abs(maxSum),  Math.abs(minSum)));
        }

        return maxAbsSum;

    }
}