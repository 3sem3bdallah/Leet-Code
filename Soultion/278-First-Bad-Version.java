public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        int temp = 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                temp = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return temp;
    }
}