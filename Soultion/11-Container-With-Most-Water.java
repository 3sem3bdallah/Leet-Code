class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, maxArea = 0;

        while (left < right) {
            maxArea = Math.max(maxArea, getArea(height, left, right));

            if (height[left] < height[right])
                left++;
            else
                right--;
        }

        return maxArea;
    }

    private int getArea(int[] height, int left, int right) {
        int width = right - left;
        return Math.min(height[left], height[right]) * width;
    }
}
