// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    int min;
    public int coinChange(int[] coins, int amount) {

        // Initialize 2 D Array with m+1 being length and n+1 being height of an array
        // as we start with o to n counting n
        int m = coins.length;
        int n = amount;
        int dp[][] = new int[m+1][n+1];

        // Initialize 1st element of array with 0
        dp[0][0] = 0;
        // Initialize 0 index next elements with Infitie / max value
        for(int j=1;j<=n; j++){
            dp[0][j] = amount+1;
        }

        // Iterate through 2d array then if 
        // the current amount (j) is less than the coin value, we can't pick that coin,
        // so we carry over the value from the row above (not picking the coin).
        // Otherwise, take the minimum of not picking the coin (value from above)
        // and picking the coin (1 + value from the same row at [j - coin value]).
        for(int i=1;i<=m;i++){
            for (int j =1;j<=n;j++){
                if(j<coins[i-1]) {
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j-coins[i-1]]);
                }
            }
        }
        if(dp[m][n] == amount+1)
        return -1;
        return dp[m][n];
}
}