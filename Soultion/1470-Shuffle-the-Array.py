class Solution:
    def shuffle(self, nums: List[int], n: int) -> List[int]:
        l1 = nums[:n]
        l2 = nums[n:]
        result = []
        
        for i in range(n):
            result.append(l1[i])
            result.append(l2[i])
        
        return result