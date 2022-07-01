//Facebook Interview
//Time Complexity : O(m*n)
//Space Complexity : o(m*n)
//coin change :Return the fewest number of coins that you need to make up that amount
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0) return -1;
  
    //consider in a matrix row as coins length and columns as amount
    int m = coins.length;
    int n = amount;
    //By using dynamic array incrementing row and column m+1 means filled with zero in java
    int[][] dp = new int[m+1][n+1];
    
    //checking the indexes of length of coins and incrementing in matrix and similarly //for amount also
    
    for(int j=1; j<n+1; j++) {
        dp[0][j] = amount+1;
    }
    for(int i=1;i<m+1;i++){
        for(int j=1;j<n+1;j++){
            //checking if amount lessthan coinslength  indexes
            if(j<coins[i-1]){
                dp[i][j] = dp[i-1][j];
            }
            else{
                //checking for minimum index value
                dp[i][j] = Math.min(dp[i-1][j],1+dp[i][j-coins[i-1]]);
            }
        }
    }
     if(dp[m][n] == amount+1){
        return -1;
     }
        //repeated subproblem store in result
        return dp[m][n];
    }
}
      