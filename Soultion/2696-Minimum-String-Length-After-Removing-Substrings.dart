class Solution {
  int minLength(String s) {
    List<String> stack = [];

    for (var c in s.split('')) {
      if (stack.isNotEmpty) {
        var top = stack.last;
        if ((top == 'A' && c == 'B') || (top == 'C' && c == 'D')) {
          stack.removeLast();
          continue;
        }
      }
      stack.add(c);
    }

    return stack.length;
  }
}
