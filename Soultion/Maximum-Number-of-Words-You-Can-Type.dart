class Solution {
  int canBeTypedWords(String text, String brokenLetters) {
    var broken = brokenLetters.split('').toSet();
    var words = text.split(' ');
    int count = 0;

    for (var word in words) {
      bool isBroken = false;
      for (var char in word.split('')) {
        if (broken.contains(char)) {
          isBroken = true;
          break;
        }
      }
      if (!isBroken) {
        count++;
      }
    }
    return count;
  }
}
