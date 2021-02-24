// Time Complexity: O(N*K)Where N is the amount and K is the total number of denominations;
// Space Complexity: O(N) where is the amaount
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
    
        vector<int> dp(amount + 1, INT_MAX);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.size(); j++) {
                if (coins[j] <= i) {
                    int sub_res = dp[i - coins[j]];
                    if(sub_res!= INT_MAX){
                    dp[i] = min(dp[i], sub_res + 1);
                    }
                }
            }
        }
        return dp[amount] == INT_MAX ? -1 : dp[amount];
    }
};