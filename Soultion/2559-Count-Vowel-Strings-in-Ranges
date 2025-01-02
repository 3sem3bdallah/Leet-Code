class Solution:
    def vowelStrings(self, words: List[str], queries: List[List[int]]) -> List[int]:
        vowels = {'a', 'e', 'i', 'o', 'u'}
        
        is_vowel_word = [False] * len(words)
        for i, word in enumerate(words):
            if word and word[0] in vowels and word[-1] in vowels:
                is_vowel_word[i] = True
        
        prefix_sum = [0] * (len(words) + 1)
        for i in range(len(words)):
            prefix_sum[i+1] = prefix_sum[i] + (1 if is_vowel_word[i] else 0)
        
        ans = []
        for l, r in queries:
            ans.append(prefix_sum[r+1] - prefix_sum[l])
        
        return ans
