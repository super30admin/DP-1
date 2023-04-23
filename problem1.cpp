// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// we use 2D dp here because we observed overlappting subproblems and important parameters are index and amount.
// dp[i][j] = min. no. of coins needed to get an amount = j and coins available are from 0 to i-1 index in coins array;

class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        if(coins.empty() || coins.size()==0){
            return -1;
        }
        vector<vector<int>>dp(coins.size()+1,vector<int>(amount+1,0));
        for(int i=0; i< amount+1;i++)
        {
            dp[0][i] = amount+1;
        }
        for(int i=1;i<coins.size()+1;i++)
        {
            for(int j=1;j<amount+1;j++)
            {
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                else
                {
                    dp[i][j] = min(dp[i-1][j],1 + dp[i][j-coins[i-1]]);
                }
            }
        }
        if(dp[coins.size()][amount] == amount+1) return -1;
        return dp[coins.size()][amount];
    }
};