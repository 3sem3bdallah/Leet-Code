class Solution:
    def isPrefixOfWord(self, sentence: str, searchWord: str) -> int:
        count = 1
        words = sentence.split()
        for word in words:
            if word.startswith(searchWord):
                return count
            count += 1
        return -1