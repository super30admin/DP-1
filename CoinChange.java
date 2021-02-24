class CoinChange {
    
    // Time Complexity: O(nw) (where n-> no. of coins and w -> amount)
    // Space Complexity: O(nw)
    
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length+1][amount+1];
        
        for(int i = 0; i <= coins.length; i++){
            for(int j = 0; j <= amount; j++){
                if(j == 0)
                    dp[i][j] = 0;
                else if(i == 0)
                    dp[i][j] = amount+1;
                else if(coins[i-1] > j)
                    dp[i][j] = dp[i-1][j];
                else{
                    int include = 1 + dp[i][j - coins[i-1]];
                    int exclude = dp[i-1][j];
                    dp[i][j] = Math.min(include, exclude);
                }
            }
        }
        return dp[coins.length][amount] == amount+1 ? -1 : dp[coins.length][amount];
    }
}