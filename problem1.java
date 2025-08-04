public class problem1 {
    //This uses bottom-up DP to find the minimum coins for each amount up to the target. It builds a dp array where dp[i] stores the fewest coins needed for amount i.
    //TC is O(m*n) and SC is O(m) where m is the amount.
    public int coinChange(int[] coins, int amount){
        int max = amount + 1;
        int[] dp = new int[max];
        for (int i = 1; i < dp.length; i++)
            dp[i] = amount + 1;
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
