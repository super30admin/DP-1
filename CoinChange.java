// Time Complexity : O(n*m), where n=input set's length, m=amount
// Space Complexity : O(n*m)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/**
 * For recursive soln, we go exhaustive, i.e. we re-calculate the output of
 * pre-calculated same sub-problem. TC => O(2^(m+n))
 * To optimize, we memoize the outputs of the sub-problems by storing them inside
 * an array. We can further optimize on space as well.
 */
public class CoinChange {


    public int coinChangeRecursive(int[] coins, int amount) {
        int res = helper(coins, 0, amount, 0);

        if (res == Integer.MAX_VALUE) return -1;
        return res;
    }

    private static int helper(int[] coins, int idx, int amountTillNow, int coinsUsed) {
        //base
        if (amountTillNow < 0 || idx == coins.length) return Integer.MAX_VALUE;
        if (amountTillNow == 0) return coinsUsed;
        //logic
        //choose
        int case1 = helper(coins, idx, amountTillNow - coins[idx], coinsUsed + 1);
        //dont choose
        int case2 = helper(coins, idx + 1, amountTillNow, coinsUsed);

        return Math.min(case1, case2);
    }

    public int coinChange(int[] coins, int amount) {

        int rows = coins.length;
        int cols = amount;

        int[][] dp = new int[rows + 1][cols + 1];
        dp[0][0] = 0;

        for (int i = 1; i <= cols; i++) {
            dp[0][i] = 99999;
        }

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
                }

            }
        }

        int res = dp[rows][cols];

        if (res == 99999) return -1;
        return res;
    }


}
