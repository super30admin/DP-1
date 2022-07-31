// Time Complexity :0(mn)
// Space Complexity : 0(mn)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no


class Solution {
    public int coinChange(int[] coins, int amount) {
        
    if(coins==null && coins.length !=0) return 0;
 

    int m = coins.length; int n= amount;
    int[][] dp = new int[m+1][n+1];
        
    dp[0][0] =0;
    
        for(int j=1;j<dp[0].length;j++){
            dp[0][j] = amount+1;
        }
        
        for(int i=1;i<dp.length;i++){
            for(int j=1; j<dp[0].length;j++){
                
                //check if denomination is less the coin
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j-coins[i-1]]); // compare the previous one and 
                }
            }
        }
        int res = dp[m][n];
        if(res>amount) return -1;
        return res;
        
    }
}