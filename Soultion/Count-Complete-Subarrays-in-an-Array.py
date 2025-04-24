class Solution:
    def countCompleteSubarrays(self, nums: List[int]) -> int:
        n, res = len(set(nums)), 0
        for l in range(len(nums)): 
            s = set()
            for r in range(l, len(nums)):  
                s.add(nums[r]) 
                if len(s) == n:  
                    res += 1  
        return res
