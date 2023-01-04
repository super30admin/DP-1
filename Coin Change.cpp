// Time Complexity: O(n)
// Space complexity: O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        int m = coins.size();
        int n = amount;
        // taking extra size for dummy row and column (coin of denomination 0)
        vector<vector<int>> dp(m + 1, vector<int>(n + 1, 0));
        // initializing the first row with infinity ie amount + 1, as no denomination can be greater than amount
        for(int j = 1; j < dp[0].size(); j++)
            dp[0][j] = amount + 1;
        // rest elements are 0 by default
        for(int i = 1; i < dp.size(); i++) {
            for(int j = 1; j < dp[i].size(); j++) {
                // if the amount j is less than the denomination of the coin, take coins from above
                // eg amount 4, coin denomination = 5
                if(j < coins[i - 1])
                    dp[i][j] = dp[i - 1][j];
                else
                    // take the min of above (0 / no choose) & 1 + prev amount(sub problem) (1 / choose)
                    dp[i][j] = min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
            }
        }
        if(dp[m][n] >= amount + 1) return -1;
        return dp[m][n];
    }
};

// int coinChange(vector<int>& coins, int amount) {
//         int n = coins.size();
//         if(n == 0) return 0;
//         vector<vector<int>> dp(n+1, vector<int>(amount+1, INT_MAX));
        
//         // to make amount 0 there is only 1 way i.e. to not select the coin.
//         for(int i=1;i<=n;i++) dp[i][0] = 0;
        
//         for(int i=1;i<=n;i++) {
//             for(int j=1;j<=amount;j++) {
//                 // when selecting the coin
//                 if(j - coins[i-1] >= 0 and dp[i][j - coins[i-1]] != INT_MAX) {
//                     dp[i][j] = min(dp[i-1][j], dp[i][j - coins[i-1]] + 1);
//                 } else { // when not selecting the coin
//                     dp[i][j] = dp[i-1][j];
//                 }
//             }
//         }
        
//         return dp[n][amount] == INT_MAX ? -1 : dp[n][amount];
//     }