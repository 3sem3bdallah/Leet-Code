class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int len = s.length();

        HashSet<String> dic = new HashSet<>();
        for (String word : dictionary) {
            dic.add(word);
        }

        int[] dp = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            dp[i] = dp[i - 1] + 1;

            for (int j = i - 1; j >= 0; j--) {
                String substr = s.substring(j, i);
                if (dic.contains(substr)) {
                    dp[i] = Math.min(dp[i], dp[j]);
                }
            }
        }
        return dp[len];
    }
}