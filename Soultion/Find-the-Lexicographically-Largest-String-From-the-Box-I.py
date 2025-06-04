class Solution:
    def answerString(self, word: str, numFriends: int) -> str:
        res = ""
        if numFriends == 1:
            return word
        length = len(word) - numFriends + 1
        for i in range(len(word)):
            temp = word[i : i + length]
            if temp > res:
                res = temp
        return res