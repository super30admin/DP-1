// Time Complexity : O(m*n)
// Space Complexity : O((m+1)*(n+1)) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this: understand that we need to use a tabular format to resolve the issue for O(n) 
solution but probably will not be able to do in interview yet.
// Summary: create a coins.length+1 (row) by amount+1 (column) matrix, solve problem for first type of coin, then use that 
//	    to solve for second row then that for third row and so on...
//	    one extra column is required as first column will be 0s and one extra row is required as it will be amount
//          so that first row can be populated.

class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0) return 0;
        int [][] dp = new int[coins.length + 1][amount + 1];
        //first column is all 0
        for(int i = 0; i < dp.length; i++){
            dp[i][0] = 0;
        }
        //filling top row with max values
        for(int j = 1; j < dp[0].length; j++){
            dp[0][j] = amount + 1;
        }
        
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j]; //if amount is less than denominator, get value from top row
                }else{
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-coins[i-1]]+1);
                }
            }
        }
        
        int result = dp[dp.length - 1][dp[0].length - 1];
        if(result > amount){
            return -1;
        }
        return result;
        
    }
    
}