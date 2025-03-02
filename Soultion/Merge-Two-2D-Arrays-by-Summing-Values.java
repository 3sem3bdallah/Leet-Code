class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int i = 0, j = 0;
        int n1 = nums1.length, n2 = nums2.length;
        List<int[]> result = new ArrayList<>();

        while (i < n1 || j < n2) {
            if (i < n1 && (j >= n2 || nums1[i][0] < nums2[j][0])) {
                result.add(nums1[i]);
                i++;
            } else if (j < n2 && (i >= n1 || nums1[i][0] > nums2[j][0])) {
                result.add(nums2[j]);
                j++;
            } else {
                result.add(new int[] { nums1[i][0], nums1[i][1] + nums2[j][1] });
                i++;
                j++;
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}