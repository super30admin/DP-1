//TC = O(m*n)
//SC = O(n)
//n = amount
//m = number of coins
class Solution {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int n = amount;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, amount + 1 );
        dp[0] = 0;
        for(int i = 1; i <= m; i ++ )
        {
            for(int j = 0; j <= n; j++)
            {
                //till amount is lesser than the current denomination
                if(j < coins[i-1])
                {
                    //zero case when we are not chosing that coin 
                    dp[j] = dp[j];
                }
                else
                {
                    dp[j] = Math.min(dp[j - coins[i - 1]] + 1,dp[j]); 
                }
                
            }
        }
        if(dp[n] >= amount + 1 ) return -1;
        return dp[n];
    }
}