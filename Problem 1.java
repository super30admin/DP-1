//Time Complexity: O(M x N) where M is the number of coins and N is the amount
//Space Complexity: O(M x N)

//Approach: Dynamic Programming


class coinChange {
    public int coinChange(int[] coins, int amount) {
        if(coins.length == 0 || coins == null) return 0;
        int[][] dp = new int[coins.length + 1][amount + 1];
        
        for(int i = 1; i < dp[0].length; i++)
        {
            dp[0][i] = 999999;
        }
        
        for(int i = 1; i < dp.length; i++)
        {
            for(int j = 1; j < dp[0].length; j++)
            {
                if(coins[i-1] > j)
                {
                    dp[i][j] = dp[i-1][j];
                }
                else
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j-coins[i-1]]);
            }
        }
        if(dp[dp.length-1][dp[0].length-1] == 999999) return -1;
        else return dp[dp.length-1][dp[0].length-1];
    }
}