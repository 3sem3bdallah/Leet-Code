class Solution {
  List<int> dailyTemperatures(List<int> temperatures) {
  int n = temperatures.length;
  List<int> answer = List.filled(n, 0);
  List<int> stack = []; // stack of indices

  for (int i = n - 1; i >= 0; i--) {
    while (stack.isNotEmpty && temperatures[i] >= temperatures[stack.last]) {
      stack.removeLast();
    }

    if (stack.isNotEmpty) {
      answer[i] = stack.last - i;
    }

    stack.add(i);
  }

  return answer;
  }
}