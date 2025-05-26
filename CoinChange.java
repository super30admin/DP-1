public class CoinChange {
    // ------------------------- Solution 1 ---------------------------
    /**
     * Greedy solution doesn't work, so exhaustive solution which will explore all paths of possible
     * coin selections and find the minimum coins.
     *
     * Time O(2^(m+n)) m = given target amount and n = number of coin denominations
     */
    public int coinChange1(int[] coins, int amount) {
        int result = helper1(coins, 0, amount);

        if (result >= Integer.MAX_VALUE - 100) {
            return -1;
        }
        return result;

    }

    public int helper1(int[] coins, int idx, int target) {
        //base
        if (target == 0) return 0;
        if (target < 0 || idx == coins.length) return Integer.MAX_VALUE - 100;

        //dont choose
        int choice1 = helper1(coins, idx + 1, target);

        //choose
        int choice2 = 1 + helper1(coins, idx, target - coins[idx]);

        return Math.min(choice1, choice2);
    }

    // ------------------------- Solution 2 ---------------------------
    /**
     * DP with tabulation -bottom-up solution
     * Time O(m*n) Space O(m*n)
     */
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int m = amount;
        int[][] dp = new int[n + 1][m + 1]; //dummy row and 0 to amount columns
        dp[0][0] = 0; // this is to satisfy coins (0,1) and make 0 amount case, where coin 1 can't be used and no choose coin 1 will depend on coins(0) make 0

        //fill dummy row
        for (int j = 1; j <= m; j++) {
            dp[0][j] = Integer.MAX_VALUE - 10; //To avoid integer overflow
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                //till amount < coin denomination
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else { // min of above case or same coin row go previous by coin denomination
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                }
            }
        }

        if(dp[n][m] >= Integer.MAX_VALUE - 10) {
            return -1;
        }
        return dp[n][m];
    }
}
