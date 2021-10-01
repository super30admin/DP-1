// Time Complexity : O(mxn)
// Space Complexity : O(mxn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int coinChange(int[] coins, int amount) {

        int n = coins.length + 1;
        int m = amount + 1;

        int[][] dp = new int[n][m];

        // Init Row

        for (int j = 1; j < m ;j++){

            dp[0][j] = amount + 1;
        }

        // Init Col
        for (int i = 0; i < n ;i++){

            dp[i][0] = 0;

        }

        // DP

        for (int i = 1;i< n ; i++){
            for(int j = 1; j < m; j++){
                if( j < coins[i-1])
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = Math.min( 1 + dp[i][j - coins[i -1]],dp[i-1][j]);
            }
        }

        return dp[n-1][m-1] == amount + 1? -1 : dp[n-1][m-1];
    }
}


// Your code here along with comments explaining your approach
