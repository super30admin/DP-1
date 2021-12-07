// Time Complexity : O(N*M) where N = amount+1, M = coins.size()+1
// Space Complexity :  O(N*M)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/*
1. Come up with recursive solution
2. Build up dp table
3. return the result
*/

class Solution {
public:
    int coinChange(vector<int>& coins, int amount) 
    { 
        vector<vector<int>> dp (coins.size()+1, vector<int>(amount+1,0));
        
         for(int j=1;j<amount+1;j++)
            dp[0][j] = INT_MAX -1;
    
        
        for(int j=1;j<amount+1;j++)
        {
            if((j%coins[0]) ==0 )
                dp[1][j]=j/coins[0];
            else
                dp[1][j] = INT_MAX -1;
        }
        
        for(int i=2;i<coins.size()+1;i++)
        {
            for(int j=1;j<amount+1;j++)
            {

                if(j < coins[i-1])
                    dp[i][j] = dp[i-1][j];     
                    
                else
                    dp[i][j] = min(1+ dp[i][j-coins[i-1]], dp[i-1][j]);
            }      
        }
        
        if(dp[coins.size()][amount] == INT_MAX-1)
            return -1;
        return dp[coins.size()][amount];
    }
};
