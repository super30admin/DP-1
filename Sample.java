// Time Complexity : O(m*n) where m is the number of coins and n is the amount
// Space Complexity : o(m*n) where m is the number of coins and n is the amount
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : not exactly, but I had to be careful 
// with the initialization of the dp array to avoid overflow issues.


// Your code here along with comments explaining your approach
// As discussed in class, Greedy or selective approach will not work here, 
// as we might end up with a local optimal solution.
// We have to go with exhaustive approach, 
// where we will try all the combinations of coins to make up the amount.
// But it will lead to exponential time complexity,
//  so we will use dynamic programming to optimize it.
// The input variables are coins and amount,which are changing, so we will create a dp array of size (m+1) x (n+1) where m is the number of coins and n is the amount.
// For every amount, if 0 - not choose we will take the value from the previous row,
//  if we choose the coin, we will take 1 + value from the same row and column - coin value.
// Lastly, we will return the value at the bottom right corner of the dp array, if it is still the initialized value, we will return -1,
//  otherwise we will return that value.
class Solution {
    public int coinChange(int[] coins, int amount) {

        int m = coins.length;
        int n = amount;

        int[][] dp = new int[m + 1][n + 1];

        dp[0][0] = 0;

        // Initialize top row with a large value
        for (int j = 1; j <= n; j++) {
            dp[0][j] = Integer.MAX_VALUE - 10; // avoid overflow
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= n; j++) {

                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(
                        dp[i - 1][j],
                        1 + dp[i][j - coins[i - 1]]
                    );
                }
            }
        }

        int res = dp[m][n];

        if (res == Integer.MAX_VALUE - 10) return -1;
        return res;
    }
}