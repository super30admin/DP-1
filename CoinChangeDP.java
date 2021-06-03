class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0) {
            return -1;
        }
        int i, j;
        int[][] dp = new int[coins.length + 1][amount + 1];
        // fill first col with 0's and first row with inf (here infinity is amount + 1)
        for(i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for(j = 1; j < dp[0].length; j++) {
            dp[0][j] = amount + 1;
        }
        for(i = 1; i < dp.length; i++) {
            for(j = 1; j < dp[0].length; j++) {
                if(j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j - coins[i - 1]]);
                }
            }
        }
        int result = dp[dp.length - 1][dp[0].length - 1];
        if (result > amount) {
            return -1;
        }
        return result;
    }
}