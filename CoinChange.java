// Time Complexity : O(m * n)
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution{
    public int coinChange(int[] coins, int amount){
        // return -1 if array is null or empty
        if(coins == null || coins.length ==0) return -1;
        // initialize dp matrix
        int dp[][] = new int[coins.length + 1][amount + 1];
        // make the first element of first row of dp matrix = 0
        dp[0][0] = 0;
        // make the rest of the elements of first row of dp matrix = amount + 1
        for(int j = 1; j < dp[0].length; j++){
            dp[0][j] = amount + 1;
        }
        for(int i = 1; i < dp.length; i ++){
            for(int j = 1; j < dp[0].length; j++){
                // for each cell of matrix, check amount less than denomination of coin
                if(j < coins[i - 1]){
                    // if the amount is less than denomination of coin,
                    // then fill the element with value of element just above
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // if the amount is not less than denomination of coin,
                    // take the min value between the element just above
                    // and 1 + the element present in the same row, the value of denomination columns before
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                }
            }
        }
        int result = dp[dp.length - 1][dp[0].length - 1];
        // if the last element of the matrix is greater than the amount than return -1
        if(result > amount) return -1;
        return result;
    }
}