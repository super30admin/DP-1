/**
 * time/space complexity is O(n*k) - n is number of coins k - amount
 */
public class MinCoinBottomup {
    public int coinChange(int[] coins, int amount) {
        Integer dp[][] = new Integer[coins.length+1][amount+1];
        
        for(int i = 0; i <= amount; i++) {
            dp[0][i] = Integer.MAX_VALUE;
        }
        for(int i = 0; i <= coins.length; i++) {
            dp[i][0] = 0;
        }
        
        for(int i = 0; i < coins.length; i++) {
            for(int j = 1; j <= amount; j++) {
                if(j >= coins[i] && dp[i+1][j-coins[i]] != Integer.MAX_VALUE) {
                    dp[i+1][j] = Math.min(dp[i][j], 1 + dp[i+1][j-coins[i]]);
                }
                else {
                    dp[i+1][j] = dp[i][j];
                }
            }
        }
        
        return dp[coins.length][amount] == Integer.MAX_VALUE ? -1 : dp[coins.length][amount];
    }
}
