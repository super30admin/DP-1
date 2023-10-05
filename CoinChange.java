// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
 

// Your code here along with comments explaining your approach
class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int n = amount;
        int[][] dp = new int[m+1][n+1];
        for(int i=1;i<=n;i++){
            dp[0][i] = amount+1;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                // min coin change is min of the previous solution (excluding the current denomination coin) 
                //and the no. of coins needed if we include the current denomination
                else
                    dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j-coins[i-1]]);
            }
        }
        int minCoins = amount + 1;
        if(dp[m][n]>=amount+1) return -1;
        return dp[m][n];
    }   
    
}