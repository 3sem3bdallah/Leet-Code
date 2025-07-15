class Solution {
  bool isValid(String word) {
    final pattern = RegExp(
      r'(?=.*[b-df-hj-np-tv-z])(?=.*[aeiou])^[a-z0-9]{3,}$',
      caseSensitive: false,
    );
    return pattern.hasMatch(word);
  }
}
