//TC = O(m*n)
//SC = O(m*n)

class Solution {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int n = amount;
        int[][] dp = new int[m + 1][n + 1];
        Arrays.fill(dp[0], amount + 1 );
        dp[0][0] = 0;
        for(int i = 1; i <= m; i ++ )
        {
            for(int j = 0; j <= n; j++)
            {
                //till amount is lesser than the current denomination
                if(j < coins[i-1])
                {
                    //zero case when we are not chosing that coin 
                    dp[i][j] = dp[i-1][j];
                }
                else
                {
                    dp[i][j] = Math.min(dp[i][j - coins[i - 1]] + 1,dp[i-1][j]); 
                }
                
            }
        }
        if(dp[m][n] >= amount + 1 ) return -1;
        return dp[m][n];
    }
}