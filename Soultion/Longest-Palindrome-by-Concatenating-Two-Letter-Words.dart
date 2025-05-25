class Solution {
  int longestPalindrome(List<String> words) {
    Map<String, int> freq = {};
    for (String word in words) {
      freq[word] = (freq[word] ?? 0) + 1;
    }

    int palindromeLength = 0;
    bool hasOddCenteredWord = false;
    Set<String> visited = {};

    for (String word in freq.keys) {
      if (visited.contains(word)) continue;
      String reversed = word[1] + word[0];
      int count = freq[word]!;

      if (word == reversed) {
        palindromeLength += (count ~/ 2) * 4;
        if (count % 2 == 1) hasOddCenteredWord = true;
      } else if (freq.containsKey(reversed)) {
        int pairs = min(count, freq[reversed]!);
        palindromeLength += pairs * 4;
        visited.add(reversed);
      }

      visited.add(word);
    }

    if (hasOddCenteredWord) palindromeLength += 2;
    return palindromeLength;
  }
}