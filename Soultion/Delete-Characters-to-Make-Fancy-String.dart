class Solution {
  String makeFancyString(String s) {
    StringBuffer result = StringBuffer();
    String lastChar = '';
    int count = 0;

    for (int i = 0; i < s.length; i++) {
      if (s[i] == lastChar) {
        count++;
      } else {
        count = 1;
        lastChar = s[i];
      }

      if (count > 2) {
        continue;
      }
      
      result.write(s[i]);
    }

    return result.toString();
  }
}