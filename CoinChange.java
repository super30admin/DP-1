public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int m = amount;
        int n = coins.length;
        int[][] dp = new int[n+1][m+1];
        for(int j = 1; j <= m; j++){
            dp[0][j] = amount + 1;
        }
        for(int i = 1; i<=n; i++){
            for(int j =1; j<=m;j ++){
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j-coins[i-1]]);
                }
            }
        }
        if(dp[n][m]>amount) return -1;
        return dp[n][m];
    }
}
