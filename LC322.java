
// Time Complexity : O(M*N)
// Space Complexity : O(M*N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
	

class Solution {
    public int coinChange(int[] coins, int amount) {
        
        //initialize a matrix to store all the values for operations
        int[][] dp = new int[coins.length + 1][amount + 1];
        
        //to fill out 0's for the first column
        for(int i = 0; i <= coins.length; i++){
            dp[i][0] = 0;
        }
        
        //to fill out the max value for the first row
        for(int j = 1; j <= amount; j++){
            dp[0][j] = 99999; // INTMAX
        }
        
        //now we start adding values to the matrix
        for(int i = 1; i <= coins.length; i++){
            for(int j = 1; j <= amount; j++){
                //if the current index j is less than the coin on which we are currently, then just copy paste the value from right above
                if(j < coins[i - 1]){
                    dp[i][j] = dp[i-1][j];
                }
                //else, we find the min of the above value and the value which is coins[i-1] steps back + 1. We add the minimum of both because we need minimum no of coins
                else{
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j - coins[i-1]]);
                }
            }
        }
        
        return dp[coins.length][amount] == 99999 ? -1 : dp[coins.length][amount];
        
}
}