// Time Complexity :O(coins.size()*amount)
// Space Complexity :O(coins.size()*amount)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : Getting up with the iterative approach


// Your code here along with comments explaining your approach

// In this the deciding factors are amount and the coins array , So I decided to take a 2D array in 
// which coins array elements as the column and amount as the rows. Extra row and column has been taken
//  to avoid the boundary checkings while we try to fill the remaining columns;
// The matrix contains the minimum number of coins required to get that particular amount


int coinChange(vector<int>& coins, int amount) {
        
       vector<vector<int>> dp(coins.size()+1, vector<int>(amount+1, 0));

        for(int i=0;i<amount+1;i++)
        {
            // If the amount cannot be formed with the given coin value instead of infinity() I am using the amount+1 
            dp[0][i] = amount+1;
        }
        for(int i=1;i<dp.size();i++)
        {
            for(int j=1;j<dp[0].size();j++)
            {
                // If the amount is less than the coin value I am filling it with previous row value
                if(j<coins[i-1]) 
                dp[i][j]=dp[i-1][j];
                else
                dp[i][j]=min(dp[i-1][j],dp[i][j-coins[i-1]]+1);
            }
       
        }
            if(dp[dp.size()-1][dp[0].size()-1]==amount+1)
            return -1;
            else
            return dp[dp.size()-1][dp[0].size()-1];
    }