import java.util.List;
class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int pointer1 = 0, pointer2 = 0;

        while (pointer1 < nums1.length && pointer2 < nums2.length) {
            if (nums1[pointer1] < nums2[pointer2]) {
                pointer1++;
            } else if (nums1[pointer1] > nums2[pointer2]) {
                pointer2++;
            } else {
                return nums1[pointer1]; 
            }
        }
        return -1;
    }
}
