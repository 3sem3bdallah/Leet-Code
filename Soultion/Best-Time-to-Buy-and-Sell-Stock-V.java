1class Data {
2    long profit = 0, buy = 0, sell = 0;
3
4    Data(long profit, long buy, long sell) {
5        this.profit = profit;
6        this.buy = buy;
7        this.sell = sell;
8    }
9}
10
11class Solution {
12    static public long maximumProfit(int[] prices, int k) {
13        final int x0 = prices[0], n = prices.length;
14        Data[] dp = new Data[k + 1];
15        for (int t = 0; t <= k; t++)
16            dp[t] = new Data(0, -x0, x0);
17        for (int i = 1; i < n; i++) {
18            final int x = prices[i];
19            for (int t = k; t > 0; t--) {
20                Data cur = dp[t];
21                long prevP = dp[t - 1].profit;
22                cur.profit = Math.max(cur.profit, Math.max(cur.buy + x, cur.sell - x));
23                cur.buy = Math.max(cur.buy, prevP - x);
24                cur.sell = Math.max(cur.sell, prevP + x);
25            }
26        }
27        return dp[k].profit;
28    }
29}