class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        int n = differences.length;
        long sum = 0;
        long maxa = 0;
        long mini = 0;
        for (int i = 0; i < n; i++) {
            sum += differences[i];
            maxa = Math.max(maxa, sum);
            mini = Math.min(mini, sum);
        }
        return (int) Math.max(0, (upper - lower) - (maxa - mini) + 1);
    }
}