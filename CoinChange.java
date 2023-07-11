// TC - O (n)
// SC - O (n)
class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int len = coins.length;
        int[][] dp = new int[len+1][amount+1];
        
        for(int i = 1; i <= amount; i++) {
            dp[0][i] = amount+1;
        }

        for(int i = 1; i <= len; i++) {
            for(int j = 1; j <= amount; j++) {
               if(j < coins[i-1]) {
                   dp[i][j] = dp[i-1][j];
               } else {
                   dp[i][j] = Math.min(dp[i-1][j], 1+ dp[i][j - coins[i-1]]);
               }
            }
        }
        if(dp[len][amount] > amount) return -1;
        return dp[len][amount];
    }
}