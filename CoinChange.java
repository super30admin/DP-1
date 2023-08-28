// Time Complexity : O(m*n) m=coines,n=amount
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// we use bottom up approach of exhaustive with recursion
class Solution {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int n = amount;
        int[][] dp = new int[m+1][n+1];
        for(int i = 1; i <= n; i++) {
            dp[0][i] = amount+10;// as inifinte dummy input to follow the pattern
        }
        for(int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }
        //DP table has pattern
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <=n; j++) {
                if( coins[i-1] > j ) {
                    //case 0: just above; not inculded
                    dp[i][j] = dp[i-1][j];
                } else {
                    //case 1: is cuurent coins steps backs
                    dp[i][j] = Math.min( dp[i-1][j], 1 + dp[i][j-coins[i-1]]);
                }
            }
        }
        if( dp[m][n] >= amount+10) {
            return -1;
        }
        return dp[m][n];
    }
    }

