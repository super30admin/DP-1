// Time Complexity : O(m * n)
// Space Complexity : O(m * n)

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*

Will create 2D array (Matrix) as we have 2 constraints - Amount and No. of coins used

First row and column will be dummy 

If the current amount ( j ) is less than coin denomination -- Simply put the value from above cell

Otherwise, choose min from above and go back from (curr amount - coin denomination) STEPS in same row and select . 


Value at last row and last column will be the minimum no. of coins required for given amount.
*/

class Solution {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int n = amount;
        
        int[][] dp = new int[m+1][n+1];
        
        for(int j = 1; j < dp[0].length; j++){
            dp[0][j] = amount + 1;
        }
        
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(j < coins[i-1]){ // If denomination is less than amount or j
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.min( dp[i-1][j], 1 + dp[i][j - coins[i-1]] );
                }
            }
        }
        
        int result = dp[dp.length-1][dp[0].length-1];
        
        if(result > amount) return -1;
        
        
        return result;
        
    
    }
    
}