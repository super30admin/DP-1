// Time Complexity : O(mxn) where m is the number of length of coins array, n is the amount
// Space Complexity : O(mxn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length + 1, n = amount+1;
        int[][] dp = new int[m][n];
        for(int i = 1; i < n; i += 1) {
            dp[0][i] = amount + 2;
        }
        for(int i = 1; i < m; i += 1) {
            for(int j = 1; j < n; j += 1) {
                if(j < coins[i - 1]) {
                    dp[i][j] = dp[i-1][j];
                    continue;
                }
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j - coins[i - 1]] +1);
            }
        }
        int result = dp[m-1][n-1];
        if(result > amount) return -1;
        return result;
    }
}