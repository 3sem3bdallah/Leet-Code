class Solution {
  int maximumCount(List<int> nums) {
    int neg = 0, pos = 0;
    
    for (int num in nums) {
      if (num > 0) pos++;
      else if (num < 0) neg++;
    }
    
    return max(pos, neg);
  }
}