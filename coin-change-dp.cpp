// Time Complexity : O(n^2)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        vector<vector<int>> dp(coins.size() + 1, vector<int>(amount + 1));
        dp[0][0] = 0;
        for(int i = 0; i <= amount; i++){
            dp[0][i] = 99999;
        }

        for(int i = 1; i <= coins.size(); i++){
            for(int j = 1; j <= amount; j++){
                if(coins[i - 1] > j){
                    dp[i][j] = dp[i -1][j];
                }
                else{
                    dp[i][j] = min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                }
            }
        }
        if(dp[coins.size()][amount] >= 99999) return -1;
        return dp[coins.size()][amount];
    }
};