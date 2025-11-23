// Time Complexity : O(m * n)
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
After understanding the repeated sub-problems, constructed a dp matrix where m is the coins and n is the amount
dp at specific row and column is the repeated subproblem of row above and denomination - columns
Since in column, we came till there by taking a coin we add +1 and find the minimum
*/


public class Problem1 {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int n = amount;

        int[][] dp = new int[m+1][n+1];
        for(int j = 1;j<=n;j++) {
            dp[0][j] = amount+1;
        }

        for(int i = 1;i<=m;i++) {
            for(int j = 1;j<=n;j++) {
                if(coins[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j - coins[i-1]]);
                }
            }
        }

        if(dp[m][n] > amount) {
            return -1;
        }

        return dp[m][n];
    }
}
