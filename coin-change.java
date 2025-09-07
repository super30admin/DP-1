class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = amount;
        int m = coins.length;
        int[][] dp = new int[m+1][n+1];
        for(int j = 1; j <= n; j++){ // 0 denomination coin row
            dp[0][j]=Integer.MAX_VALUE - 10;
        }
        //Creating the 2D array
        for(int i = 1; i <= m; i++){
            for(int j = 0; j <= n; j++){
                if(coins[i-1] > j){//the amount is less than denominations
                    dp[i][j]=dp[i-1][j];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j-coins[i-1]]);
                }
            }
        }
        int re = dp[m][n];
        if(re >= Integer.MAX_VALUE-10) return -1;
        return re;
    }
}

//tc : O(m*n)
//sc : O(m*n)
