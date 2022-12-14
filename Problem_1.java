// Coin Change
// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Approach
// After drawing the tree, will find the repeated sub problem and will come to know that it's a dp problem.
// The variables are amount and the types of coin. So will consider a dp matrix. There will be one dummy row too.
// Then we have to fill the matrix. 0 case above the row. Calculate minimum between that above row and 1+ denomination num of steps back

class Solution {
    public int coinChange(int[] coins, int amount) {
        //null
        if(coins == null || coins.length == 0)
            return 0;

        int m = coins.length;
        int n = amount;
        int[][] dp = new int[m+1][n+1];

        for(int j = 0; j<= n; j++) {
            dp[0][j] = 99999; //fill the 0 row. take a very big number or we can take amount +1 also
        }
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                //j is the amount & i is index & coin[i] is the value of coins
                //denomination of coin is less than the amount
                if(j < coins[i-1])
                    dp[i][j] = dp[i-1][j]; //0 case just above, previous row same column
                else                  //above case, that many denomination steps back
                    dp[i][j] = Math.min( (dp[i-1][j]), (1+ dp[i][j - coins[i-1]]) );
            }
        }
        if(dp[m][n] >= 99999)
            return -1;
        else
            return dp[m][n];
    }
}