// Time complexity O(m*n)
// SPace complexity O(m*n)
class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        int m = amount;
        int n = coins.size();
        
        vector<vector<int>> dp(n+1, vector<int>(m+1, 99999));
        dp[0][0] = 0;
        for (int i = 1; i <=n; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                // if current amount j is less than the denomination of current coin.
                if (j < coins[i-1]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = min(dp[i-1][j], 1 + dp[i][j - coins[i-1]]);
                }
            }
        }

        if (dp[n][m] >= 99999) return -1;
        return dp[n][m];

    }
};