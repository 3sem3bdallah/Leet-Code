class Solution {
  int countMaxOrSubsets(List<int> nums) {
    int maxOr = 0;
    for (int n in nums) maxOr |= n;
    return helper(0, nums, 0, maxOr);
  }

  int helper(int i, List<int> nums, int currOr, int maxOr) {
    if (i >= nums.length) return currOr == maxOr ? 1 : 0;
    int include = helper(i + 1, nums, currOr | nums[i], maxOr);
    int exclude = helper(i + 1, nums, currOr, maxOr);
    return include + exclude;
  }
}