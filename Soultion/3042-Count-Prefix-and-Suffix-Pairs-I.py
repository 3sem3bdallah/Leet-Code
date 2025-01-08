class Solution:
    def countPrefixSuffixPairs(self, words: List[str]) -> int:
        count = 0

        for i in range(len(words)):
            for j in range(i + 1, len(words)):
                w1, w2 = words[i], words[j]

                if w2.startswith(w1) and w2.endswith(w1):
                    count +=1
        return count

# or like this, both O(n^2)

class Solution:
    def countPrefixSuffixPairs(self, words: List[str]) -> int:
        count = 0

        for i in range(len(words)):
            for j in range(i + 1, len(words)):
                size = len(words[i])

                if words[i] == words[j][:size] and words[i] == words[j][-size:]:
                    count += 1
                    
        return count
