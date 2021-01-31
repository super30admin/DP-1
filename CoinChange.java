/**
Time Complexity : O(n^2)
Space Complexity : O(n*m)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
*/

class Solution {
    /**
    Approach:
    - This problem will be solved using the Dynamic Programming approach.
    - This is done by creating a 2-D matrix with rows representing the coins and columns representing the amount.
    - Each cell in the matrix, for example [2,2] represents how we can get amount 2 from coins [1,2].
    - Then we fill the dp matrix:
      If amount at j < coins[i-1], we just copy the value from the row above.
      Else, we compute the min of (1 + dp[i][j-coins[i-1]], dp[i-1][j])
    */
    public int coinChange(int[] coins, int amount) {
        int n = coins.length + 1;
        int m = amount + 1;
        
        int[][] dp = new int[n][m];
        
        for(int j=0; j<m; j++) {
            dp[0][j] = 99999;
        }
        
        for(int i=0; i<n; i++) {
            dp[i][0] = 0;
        }
        
        for(int i=1; i<n; i++) {
            for(int j=1; j<m; j++) {
                if(j < coins[i-1]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.min(1 + dp[i][j-coins[i-1]], dp[i-1][j]);
                }
            }
        }
        return dp[n-1][m-1] == 99999 ? -1 : dp[n-1][m-1];
    }
}
