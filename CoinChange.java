class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        else{
            int [][] dp = new int[coins.length+1][amount+1];
        int i,j,min;
        dp[0][0]=0;
        for(j=1;j<=amount;j++){
            dp[0][j]=99999;
        }
        for(i=1;i<dp.length;i++){
            for(j=0;j<dp[0].length;j++){
                if(j<coins[i-1]) {
                    dp[i][j]=dp[i-1][j];
                }
                else{
                    dp[i][j]=Math.min(dp[i-1][j],dp[i][j-coins[i-1]]+1);
                }
            }
        }
        min=dp[dp.length-1][dp[0].length-1];
        if(min==99999) return -1;
        else return min;
        }
        
    }
}