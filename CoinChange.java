// Time Complexity : O(NM) :: N -> No. of Denominations M :: Amount
// Space Complexity : O(NM)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// This is the Bottom up DP
class CoinChange {
    public int coinChange(int[] coins, int amount) {

        if (coins == null || coins.length == 0) return 0;

        int r = coins.length;
        int c = amount;

        // we are taking dummy 0th row
        int[][] dp = new int[r + 1][c + 1];

        // Initialize dummy row
        dp[0][0] = 0;
        for (int j = 1; j < dp[0].length; j++) {
            dp[0][j] = amount + 1; // Impossible value = Infinity
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {

                // If amount < coin denomination -> Do not select -> Take previous
                if (j < coins[i - 1])// why i-1 ? -> as there is dummy row
                {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // Min between pick and non-pick
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                }

            }
        }

        // CHOOSING Between Invalid and Valid Result
        return dp[r][c] >= amount + 1 ? -1 : dp[r][c];
    }

}
/*

This is Exhaustive approach based on Pick and Non-pick
// Time Complexity : O(2 ^ N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : No -> Getting Time limit exceeded error

class Solution {

    private int helper(int[] coins, int amount, int index, int min) {

        if (amount == 0) return min;

        if (amount < 0 || index >= coins.length) return -1;

        // pick up the coin
        int i = helper(coins, amount - coins[index], index, min + 1);

        // not pickup
        int j = helper(coins, amount, index + 1, min);

        if (i == -1) return j;
        else if (j == -1) return i;
        else return Math.min(i, j);

    }

    public int coinChange(int[] coins, int amount) {

        if (coins == null || coins.length == 0) return 0;

        // Min number of coins required to make up the amount

        int index = 0;
        int min = 0;

        return helper(coins, amount, index, min);


    }


 */