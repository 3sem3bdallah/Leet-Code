class Solution {
    public int minimumIndex(int[] capacity, int itemSize) {
        int result = -1;

        for (int i = 0; i < capacity.length; i++) {

            if (capacity[i] >= itemSize) {

                if (result == -1 || capacity[i] < capacity[result]) {
                    result = i;
                }
            }
        }

        return result;
    }
}