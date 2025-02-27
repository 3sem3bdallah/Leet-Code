class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        HashSet<Integer> set = new HashSet<>(arr.length);
        for (int num : arr) {
            set.add(num);
        }

        int maxCount = 0;

        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                int prev = arr[j];
                int curr = arr[i] + arr[j];
                int count = 0;

                while (set.contains(curr)) {
                    count++;
                    int temp = curr;
                    curr += prev;
                    prev = temp;
                }

                if (count > maxCount) {
                    maxCount = count;
                }
            }
        }

        return maxCount > 0 ? maxCount + 2 : 0;
    }
}
