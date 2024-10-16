class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder result = new StringBuilder();
        
        int[][] counts = {{a, 'a'}, {b, 'b'}, {c, 'c'}};
        
        while (true) {
            java.util.Arrays.sort(counts, (x, y) -> y[0] - x[0]);
            
            int len = result.length();
            if (len >= 2 && result.charAt(len - 1) == counts[0][1] && result.charAt(len - 2) == counts[0][1]) {

                if (counts[1][0] == 0) {
                    break;  
                }
                result.append((char) counts[1][1]);
                counts[1][0]--;
            } else {

                if (counts[0][0] == 0) {
                    break; 
                }
                result.append((char) counts[0][1]);
                counts[0][0]--;
            }
        }
        
        return result.toString();
    }
}
