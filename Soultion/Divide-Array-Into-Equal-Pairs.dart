class Solution {
  bool divideArray(List<int> nums) {
    Map<int, int> freq = {};
    
    for (var num in nums) {
      freq[num] = (freq[num] ?? 0) + 1;
    }

    for (var count in freq.values) {
      if (count % 2 != 0) {
        return false;
      }
    }

    return true;
  }
}
