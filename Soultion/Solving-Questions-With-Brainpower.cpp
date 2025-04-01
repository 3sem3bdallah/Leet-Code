#define ll long long
class Solution {
public:
    ll mostPoints(vector<vector<int>>& q) {
        int n = q.size();
        vector<ll> dp(n + 1);
        for (int i = n - 1; i >= 0; i--) {
            int nxt = i + q[i][1] + 1;
            ll take = q[i][0] + (nxt < n ? dp[nxt] : 0);
            ll skip = dp[i + 1];
            dp[i] = max(take, skip);
        }
        return dp[0];
    }
};