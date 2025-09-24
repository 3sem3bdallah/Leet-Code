class Solution:
    def compareVersion(self, version1: str, version2: str) -> int:
        nums1 = list(map(int, version1.split('.')))
        nums2 = list(map(int, version2.split('.')))
        
        n = max(len(nums1), len(nums2))
        nums1.extend([0] * (n - len(nums1)))
        nums2.extend([0] * (n - len(nums2)))
        
        for a, b in zip(nums1, nums2):
            if a > b:
                return 1
            elif a < b:
                return -1
        return 0
