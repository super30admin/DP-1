
// Time Complexity : O(mn))
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No

#include <algorithm>
class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        
        int row = coins.size();
        int col=amount;
        vector<vector<int>> dp(row+1,vector<int>(col+1));
   
        dp[0][0]=0;
        
        for(int j=1; j<dp[0].size(); j++){
            dp[0][j]=amount+1;
        }
        
        for(int i=1; i<dp.size();i++){
            for(int j=1;j<dp[0].size();j++){
                if(j < coins[i-1]){
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j]=min(dp[i-1][j],dp[i][j-coins[i-1]]+1);
                }
            }
        }
        int result = dp[dp.size()-1][dp[0].size()-1];
        if(result > amount) return -1;
        return dp[dp.size()-1][dp[0].size()-1];
    }
};
