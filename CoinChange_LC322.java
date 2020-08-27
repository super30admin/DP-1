/**
 * Use Dynamic Programming bottom up approach
 */

// Time Complexity: O (N*K)  N=coins, K=amount
// Space Complexity: O (K) due to memoization
// Did this code successfully run on Leetcode : Yes

import java.util.Arrays;

public class CoinChange_LC322 {
    public int coinChange(int[] coins, int amount) {
        //Handle empty input
        if (coins == null || coins.length == 0 || amount == 0)
            return 0;

        //DP array to store amount
        int[] dp = new int[amount + 1];

        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i < amount + 1; i++) {
            for (int j = 0; j < coins.length; j++)
                if (coins[j] <= i)
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
