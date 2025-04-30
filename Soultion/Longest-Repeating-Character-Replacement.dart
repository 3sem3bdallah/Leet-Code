class Solution {
  int characterReplacement(String s, int k) {
    int left = 0;
    int maxLen = 0;
    int maxCount = 0;
    Map<String, int> freqCount = {};

    for (int right = 0; right < s.length; right++) {
      String ch = s[right];
      freqCount[ch] = (freqCount[ch] ?? 0) + 1;

      maxCount = freqCount.values.fold(0, (prev, curr) => curr > prev ? curr : prev);

      while ((right - left + 1) - maxCount > k) {
        String toRemove = s[left];
        freqCount[toRemove] = freqCount[toRemove]! - 1;
        left++;
      }

      maxLen = (right - left + 1 > maxLen) ? right - left + 1 : maxLen;
    }

    return maxLen;
  }
}
