import java.lang.*;
class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int n = amount;
        int m = coins.length;
        int [][] dp= new int[m+1][n+1];
        
        //for first row
        for(int j=1; j<dp[0].length;j++)
            dp[0][j]=9999999;
        
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(j<coins[i-1])
                {
                    dp[i][j]=dp[i-1][j];
                }
                
                else{
                    dp[i][j]=Math.min(dp[i-1][j], dp[i][j-coins[i-1]] +1);
                }
            }
        }

        if(dp[m][n]>=99999) 
            return -1;

    return dp[m][n];
                
                
        }
}

