
// Time Complexity : Add : O(N * M)   N - Amount  M - Coins
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes (Understanding the problem was challenging)

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;
        coinChange(coins, amount);
    }

    public static int coinChange(int[] coins, int amount) {
        // Amount is not zero indexed
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;

        for(int i=0; i<=amount; i++){
            for(int j=0; j<coins.length ; j++){
                if(coins[j] <= i) {
                    //Compare it with previously evaluated value
                    dp[i] = Math.min(dp[i], 1+ dp[i - coins[j]]);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
