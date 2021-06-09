class CoinChange01 {
    public int coinChange(int[] coins, int amount) {
        if(coins.length==0 || coins==null) return -1;
         int[][] dp=new int[coins.length+1][amount+1];
        for (int j=1;j<amount+1;j++){
            dp[0][j]=amount+1;
        }
        for (int i=0;i<coins.length+1;i++){
            dp[i][0]=0;
        }
        for(int i=1;i<=coins.length;i++){
            for(int j=1;j<=amount;j++){
                if(coins[i-1]>j){
                    dp[i][j]=dp[i-1][j];
                }
                else{
                    dp[i][j]=Math.min(dp[i-1][j],(dp[i][j-coins[i-1]])+1);
                }
            }
        }
        int result= dp[coins.length][amount];
        if(result>amount) return -1;
        
        return result;
    }
}