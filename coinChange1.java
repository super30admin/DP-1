class coinChange1 {
    public int coinChange(int[] coins, int amount) {
       if (coins == null || coins.length == 0) return -1;
        int[][] dp = new int [coins.length + 1][amount + 1];
        
        
        //first column
        for (int i = 0; i < dp.length; i++){
            dp[i][0] = 0;
        }
        //first row
        for(int j = 1; j < dp[0].length; j++){
            dp[0][j] = amount + 1;
        }
        
        for(int i = 1; i < dp.length; i++){ //filling rest of the elements of matrix
            for(int j = 1; j < dp[0].length; j++){
                if(coins[i-1] > j){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j - coins[i-1]] + 1);
                }
            }
        }
        
        int f = dp[dp.length - 1][dp[0].length - 1];
        if (f >= amount + 1) return -1 ;
        return f ;
    }
}
