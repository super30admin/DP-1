// Time Complexity : O(m*n)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
Use a 2D matrix to calculate minimun coins required to make amount
If we cant pick the current coin then we use the entry in the same column in the prev row
If not we try to get the minimun between after adding 1
*/
class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = amount;
        int m = coins.length;
        int [][] dp = new int[m+1][n+1];

        //dummy entry in matrix
        for(int j=1; j<=n; j++) {
            dp[0][j] = 99999;
        }

        for(int i=1;i<=m;i++) {
            for(int j=1;j<=n;j++) {
                //until the denominations are greater than amount
                if (coins[i-1] > j) {
                    //for 0 case
                    dp[i][j] = dp[i-1][j];
                } else {
                    // minimun of 0 and 1 case
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j - coins[i-1]]);
                }
            }
        }
        if (dp[m][n] == 99999) return -1;
        return dp[m][n]; 
    }
}
