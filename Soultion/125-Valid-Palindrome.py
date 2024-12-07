class Solution:
    def isPalindrome(self, s: str) -> bool:

        seq = []
        for char in s:
            if char.isalnum():
                seq.append(char.lower())
        print(''.join(seq))

        i,j = 0,len(seq)-1
        while j >= i:
            if seq[i] != seq[j]:
                return  False
            i += 1
            j -= 1
        return True