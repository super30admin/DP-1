/*
Time complexity - O(MN), M - no of coins, N - amount
Space complexity - O(MN)
*/
class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        if (coins.size() == 0) return -1;
        int rows = coins.size();
        vector<vector<int>> dp(rows + 1, vector<int>(amount + 1, 0));
        for (int j = 1; j <= amount; ++j){
            dp[0][j] = amount + 1;
        }
        for (int i = 1; i <= rows; ++i){
            for (int j = 1; j <= amount; ++j){
                if (j < coins[i - 1]) dp[i][j] = dp[i - 1][j];
                else {
                    dp[i][j] = min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
                }
            }
        }
        return dp[rows][amount] == amount + 1 ? -1 : dp[rows][amount];
    }
};