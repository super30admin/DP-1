// Time Complexity : O(mxn) where m is size of coin array and n is amount
// Space Complexity : O(mxn) space required to fill matrix
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) return 0;
        int m = coins.length;
        int n = amount;
        int [][] dp = new int[m+1][n+1];
        dp[0][0] = 0;
        
        //top row
        for(int j = 1 ; j < dp[0].length;j++){
            dp[0][j] = amount + 1;
        }
        
        //matrix
        
        for(int i=1; i<dp.length; i++)
        {
            for(int j=1;j<dp[0].length;j++)
            {
                //till amount was not equal to denomination
                if (j<coins[i-1])
                { //If the amount is less than the value of coin
                    dp[i][j] = dp[i-1][j];
                }
                else
                { //now I need to decide whether to choose coin or not 
                    dp[i][j] = Math.min(dp[i-1][j], 1+ dp[i][j-coins[i-1]]);
                }
            }
        }
        int result = dp[m][n];
        if (result > amount) return -1; //if no combination of coins not possible
        return result;
        
    }
    
}
