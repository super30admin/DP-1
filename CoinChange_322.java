// Time Complexity : O(n * m)  n= numbers of coins and m = numbers of amount
// Space Complexity : O(n * m)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class CoinChange_322 {
    public int coinChange(int[] coins, int amount) {
        
        int n=coins.length+1;
        int m=amount +1;
        
        int[][] dp=new int[n][m];
        
        dp[0][0]=0;
        
        // filling up with 0 for amount 0 value with all coins
        for(int i=0;i<n;i++){
            dp[i][0]=0;
        }
        
        // filling up with maximum value for zero coin value with all coins
        for(int j=1;j< m;j++){
            dp[0][j]=amount+1;
        }
        
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(j < coins[i-1] ){
                    dp[i][j]= dp[i-1][j];
                }        
                else{
                    dp[i][j]= Math.min(1+ dp[i][j-coins[i-1]],dp[i-1][j]);
                }
            }
        }
        
        //if value is maximum then return -1
        return dp[n-1][m-1]==amount+1 ? -1 : dp[n-1][m-1];
    }
}