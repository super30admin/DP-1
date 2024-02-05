import sun.font.CreatedFontTracker;

public class CoinChangeMinCoins {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0)
            return -1;

        int n = coins.length;
        int m = amount;

        int[][] dp = new int[n+1][m+1];
        dp[0][0] = 0;
        for(int j=1; j<=m; j++){
//          dp[1][j] = Integer.MAX_VALUE;
            dp[0][j] = 99999;
        }

        for(int i=1; i<=n ; i++) {
            for(int j=1; j<=m; j++){

                if(j < coins[i-1]) {
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j] , 1+ dp[i][j-coins[i-1]]);
                }

            }
        }
        int result = dp[n][m];
        if(result>= 99999) return -1;

        return result;
    }
}