// Time Complexity : O(coins*amount) 
// Space Complexity : O(coins*amoun) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int coinChange(int[] coins, int amount) {
        
        //length of rows and columns becz we took 0 also for edge case
        int[][] dp = new int[coins.length + 1][amount + 1];
        //inserting zero value at 0th index above commented egde case
            dp[0][0] = 0; 

        //filling columns starting at index 1 bcz index zero we filled above
        for(int j=1; j < dp[0].length; j++){ 
            //for top row *instead of taking infinite we took value greater than amount
            dp[0][j] = amount + 1;
        }
        
        for(int i=1; i < dp.length; i++ ){
            for(int j=1; j < dp[0].length; j++){
                
                if(j < coins[i - 1]){ //for amount < denomination coin only case 1 available
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j - coins[i - 1]] + 1);
                }                                          
            }
        }
            
            
        int result = dp[dp.length - 1][dp[0].length - 1];  //returning final row and column
        if(result > amount) return -1;
        return result;                                                  
            
        
    }
}