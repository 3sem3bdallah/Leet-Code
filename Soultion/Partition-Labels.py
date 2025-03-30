class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        h = {}
        i,j = 0,0

        res = []

        for ind,c in enumerate(s):
            h[c] = ind
        
        ind = h[s[0]]
        while j < len(s):

            if ind < h[s[j]]:
                ind = h[s[j]]

            if j == ind:
                res.append(j-i+1)
                i = ind+1
                j = ind+1
                if j == len(s):
                    break
                ind = h[s[j]]
            else:
                j += 1

        return res