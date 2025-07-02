class Solution {
  int possibleStringCount(String word, int k) {
    int n = word.length;
    List<int> runs = [];
    int count = 1;
    for (int i = 1; i < n; i++) {
      if (word[i] == word[i - 1]) {
        count++;
      } else {
        runs.add(count);
        count = 1;
      }
    }
    runs.add(count);
    int m = runs.length;
    const int mod = 1000000007;
    int total = 1;
    for (int r in runs) {
      total = (total * r) % mod;
    }
    if (m >= k) {
      return total;
    }
    int S = k - 1 - m;
    List<int> dp = List.filled(S + 1, 0);
    dp[0] = 1;
    for (int r in runs) {
      int g = r - 1;
      List<int> newdp = List.filled(S + 1, 0);
      int windowSum = 0;
      for (int j = 0; j <= S; j++) {
        windowSum = (windowSum + dp[j]) % mod;
        if (j > g) {
          windowSum = (windowSum - dp[j - g - 1] + mod) % mod;
        }
        newdp[j] = windowSum;
      }
      dp = newdp;
    }
    int invalid = 0;
    for (int j = 0; j <= S; j++) {
      invalid = (invalid + dp[j]) % mod;
    }
    int ans = (total - invalid + mod) % mod;
    return ans;
  }
}