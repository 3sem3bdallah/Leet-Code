class Solution {
    public int maximumSum(int[] nums) {
        int n = nums.length, ans = -1;
        HashMap<Integer, Integer> mp = new HashMap<>();

        for (int x : nums) {
            int tmp = x, sum = 0;
            while (tmp != 0) {
                sum += tmp % 10;
                tmp /= 10;
            }
            if (!mp.containsKey(sum)) {
                mp.put(sum, x);
            } else {
                ans = Math.max(ans, mp.get(sum) + x);
                mp.put(sum, Math.max(mp.get(sum), x));
            }
        }

        return ans;
    }
}
