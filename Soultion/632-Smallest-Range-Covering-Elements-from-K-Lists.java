import java.util.*;

class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int k = nums.size();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;

        for (int i = 0; i < k; i++) {
            int val = nums.get(i).get(0);
            minHeap.offer(new int[] {val, i, 0}); 
            right = Math.max(right, val);
        }

        int[] res = {minHeap.peek()[0], right};

        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            left = curr[0];
            int i = curr[1];
            int idx = curr[2];

            if (right - left < res[1] - res[0]) {
                res[0] = left;
                res[1] = right;
            }

            if (idx + 1 == nums.get(i).size()) {
                break;
            }

            int nextVal = nums.get(i).get(idx + 1);
            minHeap.offer(new int[] {nextVal, i, idx + 1});
            right = Math.max(right, nextVal);
        }

        return res;
    }
}
