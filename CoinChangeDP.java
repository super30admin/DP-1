public class CoinChangeDP{
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int n = amount;
        int[][]dp = new int[m+1][n+1];
        //fill the dummy row
        dp[0][0] = 0;
        for(int i=1; i<=n; i++){
            //total no. of coins used will be = amount
            //amount 11, coins[1,2,5].. use all 1s
            //so for dummy row infinity value, take amount+1
            dp[0][i] = amount+1;
        }
        //fill the remaining rows
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                //till amount is less than denomination of the coin, val = same as above
                //denomination of coin => when i is 1, coin is 1, in coins
                //array, it is at index 0. So, coins[i-1]. Amount = j
                if(j <coins[i-1]) {
                    dp[i][j] = dp[i-1][j];
                } else{
                    dp[i][j] = Math.min(dp[i-1][j],1+dp[i][j-coins[i-1]]);
                }
            }
        }
        if(dp[m][n] >= amount+1) return -1;
        return dp[m][n];
    }

}
