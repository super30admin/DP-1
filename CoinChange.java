class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int r = coins.length;
        int c = amount;

        int[][] dp = new int[r+1][c+1];

        for(int i = 1;i <= c;i++) {
            dp[0][i] = 99999;
        }

        for(int i = 1; i <= r; i++) {
            for(int j = 1; j <= c;j++) {
                if(j < coins[i-1]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    // Min Between Choose  / No Choose
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j-coins[i-1]]);
                }
            }
        }
        if(dp[r][c] == 99999) return -1;
        return dp[r][c];
    }
}