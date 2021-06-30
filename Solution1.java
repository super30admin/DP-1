// Time complexity: O(A*C), where A is the amount and C is the length of coins array. 
// Space complexity: O(A).

import java.util.*;

class Solution1 {
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount + 1];
        // filling the array with maximum value initially.
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    // if the amount is greater than the coin amount, updating the dp[i] with the minimum number of coins required to get that amount.
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        // if dp[amount] is greater than amount, then we can't get the amount with the given coins, else return the minimum number of coins required to get the amount.
        return dp[amount] > amount ? -1 : dp[amount];
    }
}