// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Idea is we create a matrix with coin denomination as rows and amount as columns.
// For the scenarios where the amount is less than denomination of current coin, we get 
// from the lesser denomination case(just above it). For each case we calculate value based on 
// stored repeated sub problems. We get the minimum of the value between the repeated sub problems since
// we need the minimum number of coins.


#include<vector>

class Solution {
public:
    int coinChange(std::vector<int>& coins, int amount) {
        int m = coins.size();
        int n = amount;
        std::vector<std::vector<int>> dp(m+1, std::vector<int>(n+1, 0));

        // Fill the first row with large value to handle impossible scenarios.
        for(int i = 1; i <= n; i++)
        {
            dp[0][i] = 999999;
        }

        // Case where 0 coins are there for 0 amount
        dp[0][0] = 0;

        for(int i = 1; i <= m ; i++)
        {
            for(int j = 0; j <= n; j++)
            {
                // When amount is less than the denomination of coins
                if( j < coins[i-1])
                {
                    dp[i][j] = dp[i-1][j];
                }
                else
                {
                    dp[i][j] = std::min(dp[i-1][j], 1+dp[i][j-coins[i-1]]);
                }
            }
        }

        // last index of row and column gives us minimum number of coins needed to make up that amount.
        int result = dp[m][n];
        if(result == 999999)
        {
            return -1;
        }
        return result;
    }
};