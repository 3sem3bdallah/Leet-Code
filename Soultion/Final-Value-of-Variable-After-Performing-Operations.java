class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int result = 0;
        for (String op : operations) {
            if (op.equals("--X") || op.equals("X--")) {
                result -= 1;
            } else {
                result += 1;
            }
        }
        return result;
    }
}
