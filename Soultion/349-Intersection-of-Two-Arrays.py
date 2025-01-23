# Time Complexity: O(N∗M)
# Space Complexity: O(Min(N,M))

class Solution:
    def intersection(self, nums1: List[int], nums2: List[int]) -> List[int]:
        res = []
        n1 = len(nums1)
        n2 = len(nums2)

        if n1 >= n2:
            for num in nums1:
                if num in nums2 and num not in res:
                    res.append(num)
            return res
        else:
            for num in nums2:
                if num in nums1 and num not in res:
                    res.append(num)
            return res
