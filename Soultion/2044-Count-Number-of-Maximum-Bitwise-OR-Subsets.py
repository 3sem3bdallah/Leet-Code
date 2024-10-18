from typing import List

class Solution:
    def countMaxOrSubsets(self, nums: List[int]) -> int:
        max_or = 0
        for n in nums:
            max_or |= n
        
        res = 0
        
        def dfs(i, cur_or):
            nonlocal res
            if i == len(nums):
                if cur_or == max_or:
                    res += 1
                return
            
            dfs(i + 1, cur_or)
            dfs(i + 1, cur_or | nums[i])
        
        dfs(0, 0)
        return res

# sol = Solution()
# print(sol.countMaxOrSubsets([3, 1]))        # Expected output: 2
# print(sol.countMaxOrSubsets([2, 2, 2]))     # Expected output: 7
# print(sol.countMaxOrSubsets([3, 2, 1, 5]))  # Expected output: 6
