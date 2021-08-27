// TIME: O(nk) where n is the amount and k is the length of the coins array
// SPACE: O(n)
// SUCCESS on LeetCode

public class FewestCoins {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        
        for (int i = 1; i < dp.length; i++) {
            dp[i] = amount + 10;
        }
        
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < coins.length; j ++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i-coins[j]] + 1);
                } 
            }
        }
        
        return (dp[amount] > amount) ? -1 : dp[amount];
    }
}
