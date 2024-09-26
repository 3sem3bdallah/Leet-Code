\\\
we complement target to number[i], if it exist we return it and we finish.
\\\
class Solution(object):
    def twoSum(self, numbers, target):
        
        num_map = {} # dict to storage value and his index

        for i, num in enumerate(numbers): # we loop it to restore value and index
            complement = target - num
            
            if complement in num_map:
                return [num_map[complement]+1, i+1]
            
            num_map[num] = i
            
        return []