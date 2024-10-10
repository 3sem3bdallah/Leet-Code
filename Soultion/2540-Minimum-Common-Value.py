class Solution:
    def getCommon(self, nums1: List[int], nums2: List[int]) -> int:
        set_nums2 = set(nums2) 
        
        for i in nums1:
            if i in set_nums2:
                return i
        
        return -1 
