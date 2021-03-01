
// Problem1 (https://leetcode.com/problems/coin-change/)
// Time Complexity = O(n*m)
// Space Complexity = O(n*m) 


public class Problem1 {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length + 1;
        int m = amount + 1;
        
        int[][] dp = new int[n][m];
        
        for (int i=1;i<m;i++ ){
            dp[0][i] = 99999;
        }
        
        for (int j=1;j<n;j++){
            dp[j][0] = 0;
        }
        
        for (int i=1; i<n ; i++){
            for ( int j=1 ; j<m ; j++){
                if (j<coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j-coins[i-1]]);
                }
            }
        }
        return dp[n-1][m-1] == 99999? -1: dp[n-1][m-1];
    }
}
