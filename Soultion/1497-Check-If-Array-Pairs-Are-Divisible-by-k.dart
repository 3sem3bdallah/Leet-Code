class Solution {
  bool canArrange(List<int> arr, int k) {
    List<int> remainderCount = List.filled(k, 0);

    for (int num in arr) {
      int remainder = ((num % k) + k) % k; 
      remainderCount[remainder]++;
    }

    for (int i = 1; i <= k ~/ 2; i++) {
      if (remainderCount[i] != remainderCount[k - i]) {
        return false; 
      }
    }

    if (remainderCount[0] % 2 != 0) {
      return false;
    }

    if (k % 2 == 0 && remainderCount[k ~/ 2] % 2 != 0) {
      return false;
    }

    return true;
  }
}

// void main() {
//   Solution solution = Solution();
//   print(solution.canArrange([1, 2, 3, 4, 5, 10, 6, 7, 8, 9], 5));
//   print(solution.canArrange([1, 2, 3, 4, 5, 6], 7)); 
//   print(solution.canArrange([1, 2, 3, 4, 5, 6], 10)); 
// }
