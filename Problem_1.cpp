322. Coin Change

// Time Complexity :O(mxn)
// Space Complexity : O(mxn)
// Did this code successfully run on Leetcode : No


class Solution {
public:

    int coinChange(vector<int>& coins, int amount) {
        int m = coins.size();
        int n = amount;
        if (amount == 0) return 0;
        int dp[m+1][n+1];

        for (int k=0; k<=m; k++) {
            dp[k][0]  = 0;
        }
        for(int k=1; k <= n; k++) {
            dp[0][k] = amount+2; //amount+1
        }

        for(int i=1;i <= m; i++) {
            for(int j=1; j <= n; j++) {
                 if(j < coins[i-1]) {
                     dp[i][j] = dp[i-1][j];
                 } else {
                    dp[i][j] = min(dp[i-1][j], (1+(dp[i][j - coins[i-1]])));
                 }
            }
        }
        if(dp[m][n] > amount) {
            return -1;
        }
        return dp[m][n];
    }
};
