// Time Complexity : O(mn) m=length of coins array, n=amount
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// For this problem greedy doesnt work for all testcases so we need to do an exhaustive search with which recursion would give exponential time complexity.
// There are repeated subproblems so we use DP approach and store soln to these subproblems in m*n matrix
// dp[m][n] gives min no of coins that can make amount=n with the first m denominations in coins array

class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = amount;
        int m = coins.length;
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 0;
        for(int i=1;i<n+1;i++)
            dp[0][i] = amount+1;
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(j<coins[i-1])
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = Math.min(dp[i-1][j], 1+ dp[i][j-coins[i-1]]);
            }
        }
        if(dp[m][n]>amount)
            return -1;
        return dp[m][n];
    }
}