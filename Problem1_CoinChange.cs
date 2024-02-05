// Time Complexity : O(n * m)
// Space Complexity : O(n * m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Overflow issue in line 26 while adding 1 to val when val = max int value.

// Approach: Using tabulation approach of dynamic programming to solve the repeating subproblems and storing its values in matrix
// for next iterations while solving the main problem.

public class Solution {
    public int CoinChange(int[] coins, int amount) {
        int n = coins.Length + 1;
        int m = amount + 1;
        int[][] dp = new int[n][];
        dp[0] = new int[m];
        dp[0][0] = 0;
        for(int i = 1; i < m; i++) {
            dp[0][i] = Int32.MaxValue;
        }
        for(int i = 1; i < n; i++) {
            dp[i] = new int[m];
            for(int j = 0; j < m; j++) {
                if(j < coins[i-1]) {
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    int val = dp[i][j - coins[i-1]];
                    dp[i][j] = Math.Min(dp[i-1][j], (val == Int32.MaxValue ? val : 1 + val));
                }
            }
        }
        int result = dp[n-1][m-1];
        if(result == Int32.MaxValue) return -1;
        return result;
    }
}
