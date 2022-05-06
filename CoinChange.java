// Time Complexity :theta(n*m)
// Space Complexity : theta(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :Initially it was difficult while I was getting stuck in travesersing.
We have to find some subproblem that will help in solving coin-change problem. Given an amount n, we want to generate an exact change using the fewest number of coins of denominations d1 < d2 < … < dm.
class Solution {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];

        Arrays.fill(dp, max);

        dp[0] = 0;

        for (int i = 1; i <= amount ; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
