class Solution {
  int evalRPN(List<String> tokens) {
  List<int> stack = [];
  
  for (String token in tokens) {
    if (token == "+" || token == "-" || token == "*" || token == "/") {
      int b = stack.removeLast();
      int a = stack.removeLast();
      int res = 0;
      switch (token) {
        case "+":
          res = a + b;
          break;
        case "-":
          res = a - b;
          break;
        case "*":
          res = a * b;
          break;
        case "/":
          res = a ~/ b;
          break;
      }
      stack.add(res);
    } else {
      stack.add(int.parse(token));
    }
  }
  
  return stack.last;
}
}