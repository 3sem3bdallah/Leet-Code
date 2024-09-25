class Solution:
    def longestCommonPrefix(self, arr1, arr2):
        prefixes = set()
        
        for num in arr1:
            s = str(num)
            for i in range(1, len(s) + 1):
                prefixes.add(s[:i])
        
        max_length = 0
        for num in arr2:
            s = str(num)
            for i in range(1, len(s) + 1):
                if s[:i] in prefixes:
                    max_length = max(max_length, i)
        
        return max_length

solution = Solution()
print(solution.longestCommonPrefix([1, 10, 100], [1000]))
print(solution.longestCommonPrefix([1, 2, 3], [4, 4, 4])) 
