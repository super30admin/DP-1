
class MinCoinsChange {
    public int coinChange(int[] coins, int amount) {

        // int result = helper(coins, amount, 0, 0);
        // if( result == Integer.MAX_VALUE) return -1;

        int m = coins.length;
        int n = amount;
        int[][] dp = new int[m+1][n+1];
        Arrays.fill(dp[0], amount + 1);
        dp[0][0] = 0;

        for(int i = 1; i <= m; i++) {
            for(int j = 0; j <= n; j++) {
                // if amt is less than denomination
                if(j < coins[i-1]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j - coins[i-1]]);
                }
            }
        }

        if(dp[m][n] >= amount + 1) return -1;

        return dp[m][n];

        // return result;
    }

    public int helper(int[] coins, int amount, int idx, int coinsused) {
        if(amount < 0 || idx == coins.length ) return Integer.MAX_VALUE;

        if(amount == 0) return coinsused;

        //chose
        int case1 = helper(coins, amount - coins[idx], idx, coinsused + 1);

        int case2 = helper(coins, amount, idx + 1, coinsused);

        return Math.min(case1, case2);
    }
}