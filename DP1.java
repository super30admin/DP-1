// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*Initialize 0 row 0 column with 0. Constructing a DP table with values in the first row as infinity. 
If value is greater than the denomination of the coin, copy the contents of the row above it with same column. 
Else, compute the min between top row same column and same row, the coin denomination number positions left of the current position + 1.  
 * */

class Solution {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int n = amount; 
        int dp[][] = new int[m+1][n+1];
        for(int i=1; i <= n; i++)
        dp[0][i] = 99999;
        for(int i =1; i <=m; i++){
            for(int j =1; j <=n;j++){
                if(coins[i-1] > j)
                dp[i][j] = dp[i-1][j];
                else
                dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j-coins[i-1]]);
            }
        }
        if(dp[m][n] >=99999)
        return -1; 
        return dp[m][n];
    }
}