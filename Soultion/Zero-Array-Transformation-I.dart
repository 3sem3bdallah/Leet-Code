class Solution {
  bool isZeroArray(List<int> nums, List<List<int>> queries) {
    int n = nums.length;
    List<int> delta = List.filled(n + 1, 0);

    for (List<int> q in queries) {
      int l = q[0];
      int r = q[1];
      delta[l]++;
      if (r + 1 < n) delta[r + 1]--;
    }

    List<int> newDelta = List.filled(n, 0);
    newDelta[0] = delta[0];
    for (int i = 1; i < n; i++) {
      newDelta[i] = newDelta[i - 1] + delta[i];
    }

    for (int i = 0; i < n; i++) {
      int reduced = nums[i] - newDelta[i];
      if (reduced > 0) return false;
    }

    return true;
  }
}