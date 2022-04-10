// Time Complexity                              :  O(N*AMOUNT)
// Space Complexity                             :  O(N*AMOUNT)
// Did this code successfully run on Leetcode   :  Yes
// Any problem you faced while coding this      :  No

#include <bits/stdc++.h> 
using namespace std;  


class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        int n = coins.size();
        if(n == 0) return 0;
        vector<vector<int>> dp(n+1, vector<int>(amount+1, INT_MAX));
        
        // to make amount 0 there is only 1 way i.e. to not select the coin.
        for(int i=1;i<=n;i++) dp[i][0] = 0;
        
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=amount;j++) {
                // when selecting the coin
                if(j - coins[i-1] >= 0 and dp[i][j - coins[i-1]] != INT_MAX) {
                    dp[i][j] = min(dp[i-1][j], dp[i][j - coins[i-1]] + 1);
                } else { // when not selecting the coin
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        return dp[n][amount] == INT_MAX ? -1 : dp[n][amount];
    }
};