// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode :yes 

class CoinChange {
    public int coinChange(int[] coins, int amount) {
        //null checks
        if(coins == null || coins.length== 0) return 0;
        int m = coins.length;
        int n = amount;
        int[][] dp = new int [m+1][n+1];
        for(int j = 1; j<=n ; j++){
            dp[0][j] = amount + 1 ; // Here we are making infinity row, considering amount her that will be more than amount.
        }
        for(int i=1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                //till the time amount is less than denomination of coin.
                if(j<  coins[i-1]) { // We are actually at 0 index at denominations. But when making matrix we are adding one extra row. 
                    // Zero case
                    dp[i][j] = dp[i-1][j];
                }else{
                    // One case
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j-coins[i-1]]); 
                }
        }
    }
    if(dp[m][n] > amount) return -1;
    return dp[m][n];
}
}