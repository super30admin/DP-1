// Time Complexity : o(coins*amount)
// Space Complexity : o(amount)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


class Solution {
public:
    int helper(vector<int>& coins, int amount, vector<int> &dp) {
        if(amount == 0) {
            return dp[amount] = 0;
        }
        if(dp[amount] != -1) {
            return dp[amount];
        }
        int ans = INT_MAX;
        for(int i=0;i<coins.size();i++) {
            if(amount-coins[i] >= 0) ans = min(ans, helper(coins, amount-coins[i], dp));
        }
        
        if(ans == INT_MAX) {
            return dp[amount] = INT_MAX;
        }
        
        return dp[amount] = ans+1;
    }
    int coinChange(vector<int>& coins, int amount) {
        vector<int> dp(amount+1, -1);
        int ans = helper(coins, amount, dp);
        return ans == INT_MAX ? -1 : ans;
    }
};