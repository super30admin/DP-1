// Time Complexity : O(coins.length * amount)
// Space Complexity : O(coins.length * amount)
// Did this code successfully run on Leetcode : yes


// Your code here along with comments explaining your approach
/* Create a 2d array where rows represent the coins available and columns represents amounts.
 * Each cell represents the minimun coins required to create a column amount using coins of current and above rows. 
 * For each value we have two choice 
 *     Don't use the current row coin then the minimum coin value is same as the above row value for that amount.
 *     Use the current coin then minimum coins required are 1 + coins required to get (current amount - current coin value).
 * Return the minimum of these two cases. 
 */
class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        if (coins.size() == 0)
            return 0;
        
        int dp[coins.size() + 1][amount + 1];
        
        for (int i = 0; i <= amount; i++)
        {
            dp[0][i] = amount + 1;
        }
        for (int j = 0; j <= coins.size(); j++)
        {
            dp[j][0] = 0; 
        }
        
        for (int i = 1; i <= coins.size(); i++)
        {
            for (int j = 1; j <= amount; j++)
            {
                if (j < coins[i - 1])
                {
                    dp[i][j] = dp[i - 1][j];
                }
                else
                {
                    dp[i][j] = min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                }
            }
        }
        
        if (dp[coins.size()][amount] > amount)
        {
            return -1;                               
        }
                                   
        return dp[coins.size()][amount];
    }
};