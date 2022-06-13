// Time Complexity - O(n)
// Space Complexity - O(n)
// Problems Faced - No!
// It runs on leetcode.

class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        vector<vector<int>> dp(coins.size() + 1, vector<int>(amount + 1));
        int nC = dp.size();
        int nR = dp[0].size();
        
        for(int j = 1; j < dp[0].size(); j++){
            dp[0][j] = 9999;
        }
        
        for(int i = 1; i < dp.size(); i++){
            for(int j = 1; j < dp[0].size(); j++){
                if(j < coins[i-1])
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = min(dp[i-1][j], 1 + dp[i][j - coins[i-1]]);
            }
        }
        
        if(dp[nC-1][nR-1] >= 9999)
            return -1;
        return dp[nC-1][nR-1];
    }
};
