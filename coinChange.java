// Time Complexity : O(m*n)
// Space Complexity : O(m), m = amount
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * 1. Identify the repeating sub problems.
 * 2. Build the DP array bottom up using the sub problems identified in step 1 and the base case.
 * 3. Return the last element of the DP array.
 */

class Solution {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length, n = amount;
        int[] dp = new int[n+1];
        int inf = amount + 1;

        for(int i=1; i<=n; i++){
            dp[i] = inf;
        }

        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(j >= coins[i-1]){
                    dp[j] = Math.min(dp[j], 1 + dp[j - coins[i-1]]);
                }
            }
        }

        if(dp[n] >= inf){
            return -1;
        }

        return dp[n];
    }
}