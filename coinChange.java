// Time Complexity : O(nm)
// Space Complexity : O(nm)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes


// Your code here along with comments explaining your approach
class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length + 1;
        int m = amount + 1;
        int[][] dp = new int[n][m];
        
        //row
        for(int i = 1;i < m; i++){
            //dp[0][i] = Integer.MAX_VALUE;
            dp[0][i] = 99999;
        }
        
        //column
        for(int j=0;j < n;j++){
            dp[j][0] = 0;
        }
        
        for(int i = 1;i < n; i++){
            for(int j = 0;j < m; j++){
                if(j < coins[i - 1]) //coins -> 1,2,3; i -> 0,1,2
                    dp[i][j] = dp[i-1][j];
                else {
                    //min(dc,c)
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j- coins[i-1]]);
                }
            }
        }
        //return dp[n - 1][m - 1];
        return dp[n-1][m-1] == 99999 ? -1 : dp[n-1][m-1];
    }
}