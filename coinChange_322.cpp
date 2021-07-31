// Time Complexity : O(MN)
// Space Complexity :O(MN)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        if(coins.empty() || coins.size() == 0){
            return -1;
        }
        int n = coins.size();
        vector <vector <int>> dp(n + 1, vector <int> (amount + 1));
        //dp.resize(coins.size() + 1,vector<int>(amount + 1));
        for (int i = 0; i < n+1; i++)
            dp[i][0] = 0;
        for (int j=1; j<amount+1; j++)
            dp[0][j] = INT_MAX - 1;
        
        for (int i=1; i<n+1; i++){
            for(int j=1; j<amount+1; j++){
                if(j < coins[i-1])
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = min(dp[i-1][j], dp[i][j - coins[i-1]] + 1);
            }
        }
        int res = dp[n][amount];
        if(res >= INT_MAX - 1){
            return -1;
        }
        return res;
    }
};
