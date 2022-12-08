// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


public class CoinChange {
        public int coinChange(int[] coins, int amount) {
    
            // null check
            if (coins == null || coins.length == 0) return 0;
    
            int m = coins.length;
            int n = amount;
    
            int[][] dp = new int[m+1][n+1];
            dp[0][0] = 0;
    
            for (int j=1; j<=n; j++){
                dp[0][j]= amount+1;
            }
    
            for (int i=1; i<=m; i++){
                for (int j=1; j<=n; j++){
                    //denom of coin is less than amount
                    if ( j < coins[i-1]){
                        dp[i][j]= dp[i-1][j]; //Zero
                    } else {
                        dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j-coins[i-1]]);
                    }
                }
            }
            if (dp[m][n] > amount) return -1;
            return dp[m][n];
        }
    
}
