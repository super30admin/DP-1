// Time Complexity :O(n*m)
// Space Complexity :O(n*m)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class CoinChange {
    public int coinChange(int[] coins, int amount) {
        
        int n = coins.length +1 ;
        int m = amount + 1;
        int[][] dp = new int[n][m];
        for(int i=0;i<n;i++){
            dp[i][0]=0;
        }
        // System.out.println(Integer.MAX_VALUE);
        for(int j=1;j<m;j++){
            dp[0][j]= amount+1;
        }
        
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(coins[i-1]>j){
                   dp[i][j] = dp[i-1][j]; 
                }else{
                   dp[i][j] = Math.min(dp[i-1][j],1+dp[i][j-coins[i-1]]);
                }
            }
        }
        return dp[n-1][m-1] == amount+1 ? -1:dp[n-1][m-1];
    }
}