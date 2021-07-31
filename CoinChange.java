/* Time Complexity : O(M * N), where M = length of coins array, N is amount
   Space Complexity : O(M * N), where M = length of coins array, N is amount
   Did this code successfully run on Leetcode : Yes
   Any problem you faced while coding this : No
   Method: Using DP. 

*/

class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins==null || coins.length==0) return -1;
        int[][] dp = new int[coins.length+1][amount+1]; //Creating an extra array to store the values, used for memoization.
        for(int i=1;i<amount+1;i++)
            dp[0][i] = amount + 1; // filling with a value greater than amount for the 0 coin denomination.
        for(int i=1;i<dp.length;i++)
        {
            for(int j=1;j<dp[i].length;j++)
            {
                if(j < coins[i-1]) //if amount is less than coin denomination, we use the same value as previous denomination and amount
                {
                    dp[i][j]=dp[i-1][j];
                }
                else
                {
                    dp[i][j] = Math.min(dp[i-1][j], 1+ dp[i][j-coins[i-1]]);
                }
            }
        }
        int result = dp[dp.length-1][dp[0].length-1]; // result would be last row, last column value
        if(result==amount+1)
            return -1;
        return result;
    }
}