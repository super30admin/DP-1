//https://leetcode.com/problems/coin-change/
// Time Complexity : O(m*n) where m is the length of array given and n is the amount
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        int m = coins.size();
        int n = amount;
        vector<vector<int>> dp(m+1,vector<int> (n+1, 0));

        
        // now put max value for dummy row;
        for(int j = 1 ; j<n+1; j++){
            dp[0][j] = amount + 1;
        }
        
        //now fill the table
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];  // one row above
                }else{
                    dp[i][j] = min(dp[i-1][j], 1 + dp[i][j-coins[i-1]]);
                }
            }
        }
        
        if(dp[m][n] == amount+1){
            return -1;
        }
        
        return dp[m][n];
        
        
    }
};