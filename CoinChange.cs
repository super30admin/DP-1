// Time Complexity : O(MN)
// Space Complexity : O(MN)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

public class Solution {
    public int CoinChange(int[] coins, int amount) {
        if(coins == null || coins.Length ==0)
            return 0;
        
        int m = coins.Length;
        int n = amount;
        int [,] dp = new int[m+1,n+1];
        dp[0,0] = 1;
        for(int j= 1;j<=n;j++)
        {
            dp[0,j] = amount + 1;
        }        
        for(int i = 1 ; i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {                
                if(j < coins[i-1])
                    dp[i,j] = dp[i-1,j];
                else
                    dp[i,j] = Math.Min(dp[i-1,j], 1+ dp[i,j-coins[i-1]]);
            }
        }
        if(dp[m,n] >= amount+1) return -1;
        
        return dp[m,n];
    }
}
