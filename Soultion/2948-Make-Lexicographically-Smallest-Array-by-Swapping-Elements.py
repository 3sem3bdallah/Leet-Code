from collections import deque
from typing import List

class Solution:
    def lexicographicallySmallestArray(self, nums: List[int], limit: int) -> List[int]:
        groups = [] 
        num_to_group = {} 
        
        for n in sorted(nums):
            if not groups or abs(n - groups[-1][-1]) > limit:
                groups.append(deque())
            groups[-1].append(n)
            num_to_group[n] = len(groups) - 1
        
        res = []
        for n in nums:
            group_index = num_to_group[n]
            res.append(groups[group_index].popleft())
        
        return res

