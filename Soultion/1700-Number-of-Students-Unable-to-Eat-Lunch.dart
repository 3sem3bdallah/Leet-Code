class Solution {
  int countStudents(List<int> students, List<int> sandwiches) {
    int res = sandwiches.length;

    Map<int, int> cnt = {0: 0, 1: 0};
    for (var student in students) {
      cnt[student] = (cnt[student] ?? 0) + 1;
    }

    for (var s in sandwiches) {
      if (cnt[s]! > 0) {
        res -= 1;
        cnt[s] = cnt[s]! - 1;
      } else {
        return res;
      }
    }
    return res;
  }
}
