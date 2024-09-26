class Solution {
  List<int> twoSum(List<int> numbers, int target) {
    int left = 0;
    int right = numbers.length - 1;

    while (left < right) {
      int sum = numbers[right] + numbers[left];
      if (sum == target) {
        return [left + 1, right + 1];
      }
      if (sum > target) {
        right--;
      } else {
        left++;
      }
    }
    return [0];
  }
}
