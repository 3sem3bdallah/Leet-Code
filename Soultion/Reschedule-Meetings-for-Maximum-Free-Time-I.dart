class Solution {
  int maxFreeTime(int eventTime, int k, List<int> startTime, List<int> endTime) {
    int count = startTime.length;
    int maxFree = 0;
    List<int> prefixSum = List.filled(count + 1, 0);

    for (int i = 0; i < count; i++) {
      prefixSum[i + 1] = prefixSum[i] + endTime[i] - startTime[i];
    }

    for (int i = k - 1; i < count; i++) {
      int occupied = prefixSum[i + 1] - prefixSum[i - k + 1];
      int windowEnd = (i == count - 1) ? eventTime : startTime[i + 1];
      int windowStart = (i == k - 1) ? 0 : endTime[i - k];
      int freeTime = windowEnd - windowStart - occupied;
      if (freeTime > maxFree) maxFree = freeTime;
    }

    return maxFree;
  }
}