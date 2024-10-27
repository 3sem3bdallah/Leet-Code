import java.util.HashMap;
import java.util.Map;

class Solution {
    public int countSquares(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        Map<Integer, Integer> dp = new HashMap<>();

        int res = 0;
        for (int r = 0; r < rows; r++) {
            Map<Integer, Integer> curDp = new HashMap<>();
            for (int c = 0; c < cols; c++) {
                if (matrix[r][c] == 1) {
                    curDp.put(c, 1 + Math.min(
                        dp.getOrDefault(c, 0),
                        Math.min(curDp.getOrDefault(c - 1, 0), dp.getOrDefault(c - 1, 0))
                    ));
                    res += curDp.get(c);
                }
            }
            dp = curDp;
        }
        return res;
    }
}
