from collections import Counter

class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        len_s1, len_s2 = len(s1), len(s2)
        
        if len_s1 > len_s2:
            return False
        
        count_s1 = Counter(s1)

        window = Counter(s2[:len_s1])
        
        if window == count_s1:
            return True
        
        for i in range(len_s1, len_s2):

            window[s2[i]] += 1
            window[s2[i - len_s1]] -= 1
            
            if window[s2[i - len_s1]] == 0:
                del window[s2[i - len_s1]]
            
            if window == count_s1:
                return True
        
        return False

# s1 = \ab\
# s2 = \eidbaooo\
# solution = Solution()
# print(solution.checkInclusion(s1, s2)) # => True

# s1 = \ab\
# s2 = \eidboaoo\
# print(solution.checkInclusion(s1, s2))  # => False
