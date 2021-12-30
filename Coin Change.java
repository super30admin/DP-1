// Time Complexity : O(m*n) where m = amount and n = number of coin denominations
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int coinChange(int[] coins, int amount) {
        // initialize dp matrix
        int [][] dp = new int [coins.length + 1][amount + 1];
        // set the first element of first row of the dp matrix as 0
        dp[0][0] = 0;
        // set the rest of the elements of first row of dp matrix as amount + 1 (same as infinity)
        for(int j = 1; j < dp[0].length; j++){
            dp[0][j] = amount + 1;
        }
        
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                
                // for each cell of matrix, check amount is less than denomination of coin
                if(j < coins[i-1]){
                    // if the amount is less than denomination of coin,
                    // then fill the element with value of element just above
                    dp[i][j] = dp[i-1][j];
                }else{
                    // if the amount is not less than denomination of coin,
                    // then take the min value between the element just above
                    // and 1 + the element present in the same row, the value of denomination columns before
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j - coins[i-1]] + 1);
                }
            }
        }
        int lastElement = dp[dp.length - 1][dp[0].length -1];
        
        // if the last element of the matrix is greater than the amount, then return -1
        if(lastElement > amount){
            return -1;
        }
        return lastElement;
    }
}
