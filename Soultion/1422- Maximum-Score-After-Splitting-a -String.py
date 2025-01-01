class Solution:
    def maxScore(self, s: str) -> int:
        zeros, res = 0,0
        ones = s.count("1")

        for i in range (len(s)-1):
            if s[i] == '0':
                zeros +=1
            else:
                ones -=1
            res = max(res, zeros + ones)
        return res
