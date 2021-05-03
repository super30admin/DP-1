// Time Complexity :O(m*n) m - coins ,n - amount
// Space Complexity : O(m*n)  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//DP Matrix is built considering O case and 1 case which was seen from recursion tree

class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        int n = coins.size();
        int dp[n+1][amount+1];
        for(int i = 1;i<amount+1;i++){
            dp[0][i] = amount+1;
        }
        
        for(int i=0;i<coins.size()+1; i++){
            dp[i][0] = 0;
        }
        for(int i = 1;i<n+1;i++){
            for(int j = 1;j<amount+1;j++){
                if(j < coins[i-1])
                    dp[i][j] = dp[i-1][j]; //Take previous row entry for amount is less than denomination
                else{
                    dp[i][j] = min(dp[i-1][j],dp[i][j-coins[i-1]] + 1); //Min between and 0 case and 1 case 
                }
            }
        }
        return dp[n][amount] > amount? -1:dp[n][amount];
    }
};