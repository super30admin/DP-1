/**
Time Complexity : O(M*N) M = coin.length, N = amount 
Space Complexity : O(M*N) M = coin.length, N = amount 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
**/
class Solution 
{
    private final int INFINITE = 99999;
    
    public int coinChange(int[] coins, int amount) 
    {
        
        int rows = coins.length + 1;
        int cols = amount + 1;
        
        
        int dp[][] = new int[rows][cols];
        
        for(int j=0;j<cols; j++)
            dp[0][j] = INFINITE;
        
        for(int i = 1; i< rows; i++)
        {
            for(int j=1;j<cols; j++)
            {
                if(coins[i-1] > j)
                    dp[i][j] = dp[i-1][j];
                else    
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j-coins[i-1]]);
            }
        }
        
        int result = dp[rows-1][cols-1];
        
        if(result >= INFINITE)
            return -1;
        
        return result;
    }
}