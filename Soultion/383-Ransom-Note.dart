class Solution {
  bool canConstruct(String ransomNote, String magazine) {
    Map<String, int> charCount = {};

    for (var char in magazine.split('')) {
      charCount[char] = (charCount[char] ?? 0) + 1;
    }

    for (var char in ransomNote.split('')) {
      if (charCount[char] == null || charCount[char]! <= 0) {
        return false;
      }
      charCount[char] = charCount[char]! - 1;
    }

    return true;
  }
}
