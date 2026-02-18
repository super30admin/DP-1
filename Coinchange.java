// Time Complexity : O(m*n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
* Take a dp array with sizes equal to one greater than number of coins with row and one greater than amount
* as columns. Initial row would be filled with infinite value, but in ideal situation, to avoid integer
* overflow, we intialize just with amount+1. Now, we try to fill the matrix iteratively by considering
* choose and no choose scenarios. If no choose, where the amount is less than number of coins, the cell
* value comes from the value of cell just above row. If choose, we take min value between no choose and
* choose, where we obtain the value from the cell in same row and column of current amount and denomination
* of coin.If the last cell still remains with amount+1, then we return -1, if not, we return that value.
* */
class Solution {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int n = amount;

        int[] dp = new int[n + 1];

        //initialize with some infinite value and make sure to avoid Integer overflow
        for(int j = 1 ; j <= n ; j++)
            dp[j] = amount + 1;

        for(int i = 1 ; i <= m ; i++) {
            for(int j = 1 ; j <= n ; j++) {
                if(j < coins[i - 1]) //no choose case
                    dp[j] = dp[j]; // directly comes from above column
                else {
                    //find min value of choose(same row but column comes from amount - coin denomination) and no choose
                    // In choose situation, we need to add extra 1, because we are choosing a coin
                    dp[j] = Math.min(dp[j] , 1 + dp[j - coins[i - 1]]);
                }
            }
        }
        return dp[n] == amount + 1 ? -1 : dp[n];
    }
}