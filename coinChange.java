class Solution {
    //Tabular solution 
    //complexity time : O(n*m) m is amount and n is coin denomination   
    public int coinChange(int[] coins, int amount) {

        int n = coins.length;
        int m = amount;

        int[][] dp = new int[n + 1][m + 1];
        dp[0][0] = 0;

        for (int i = 1; i <= m; i++) {
            dp[0][i] = Integer.MAX_VALUE - 10;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                }

            }
        }

        if (dp[n][m] >= Integer.MAX_VALUE - 10)
            return -1;

        return dp[n][m];

    }

    //Brute Force solution
    // private int helper(int amount, int idx, int[] coins) {
    //     //base
    //     if (amount == 0)
    //         return 0;
    //     if (amount < 0 || idx == coins.length)
    //         return 9999999;
    //     //logic

    //     //conddition
    //     //to choose
    //     int toChoose = 1 + helper(amount - coins[idx], idx, coins);
    //     //to Not choose
    //     int notChoose = helper(amount, idx + 1, coins);

    //     return Math.min(toChoose, notChoose);

    // }

    // public int coinChange(int[] coins, int amount) {

    //     int result = helper(amount, 0, coins);

    //     if (result == 9999999)
    //         return -1;

    //     return result;

    // }
}