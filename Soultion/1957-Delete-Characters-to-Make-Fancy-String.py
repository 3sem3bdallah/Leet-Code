class Solution:
    def makeFancyString(self, s: str) -> str:
        result = []
        count = 0
        
        for i in range(len(s)):
            if i >= 2 and s[i] == s[i - 1] == s[i - 2]:
                continue
            result.append(s[i])
        
        return ''.join(result)
