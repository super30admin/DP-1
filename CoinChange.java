package DP;

public class CoinChange {
	public int coinChange(int[] coins, int amount) {
        if(coins==null || coins.length == 0) return 0;
        int[][] dp= new int[coins.length+1][amount+1];
        //filling first row.
        for(int i=1;i<dp[0].length;i++){
            dp[0][i]=amount+1;
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                //amount lesser
                if(j<coins[i-1]){
                    dp[i][j]=dp[i-1][j];
                }
                else{
                    dp[i][j]=Math.min(dp[i-1][j],1 + dp[i][j-coins[i-1]]);
                }
            }
        }
        if(dp[dp.length-1][dp[0].length-1]> amount) return -1;
        return dp[dp.length-1][dp[0].length-1];
    }

}
