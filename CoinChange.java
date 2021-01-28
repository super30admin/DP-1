// Time Complexity : O(1)
// Space Complexity : O(nk) - k being the amount and n being the coins
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

// Your code here along with comments explaining your approach
public class CoinChange {
    public int coinChange(int[] coins, int amount) {

        int max = amount + 1;

        // size for dp array
        int i = coins.length + 1, j = amount + 1;

        // dp array for storing max coin needed uptill then values
        int[][] dp = new int[i][j];

        // Initialinzing the array to 0 value coins for later use
        for (int k = 0; k < j; k++)
            dp[0][k] = max;

        for (int k = 0; k < i; k++)
            dp[k][0] = 0;

        // loop through all possible combinations to make the amount
        // and storing minimum number of coins needed to make a certain amount
        for (int a = 1; a < i; a++)
            for (int b = 1; b < j; b++) {
                if (coins[a - 1] > b) {
                    dp[a][b] = dp[a - 1][b];
                } else {
                    dp[a][b] = Math.min(dp[a][b - coins[a - 1]] + 1, dp[a - 1][b]);
                }
            }

        // check if we are able to make the specified amount with coins available
        return dp[i - 1][j - 1] <= amount ? dp[i - 1][j - 1] : -1;

    }
}
