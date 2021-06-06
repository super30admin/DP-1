//Time complexity - O(m*n)
//Space complexity - O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

class Solution {
   public int coinChange(int[] coins, int amount) {
      
     //using recursion method
      //null check
      if(coins.length == 0 || coins == null) {return 0;}
      //dp matrix
      int [][] dp = new int[coins.length+1][amount+1];
      //fill in first column
      for(int i=0;i<dp.length;i++) {
        dp[i][0] = 0;
      }
      //fill the dummy row
      for(int j=1;j<dp[0].length;i++) {
        dp[0][j] = amount+1;
      }
      
      for(int i =1; i<dp.length;i++) {
        int (j=1; j< dp[0].length;j++) {
          if(coins[i-1] > j) { //denom is less than amount
            dp[i][j] = dp[i-1][j];
            
          } else {
            dp[i][j] = Math.min(dp[i-1][j+1], 1+dp[i][j-coins[i-1]] )

          }
        } 
      }
      int result = dp[dp.length-1][dp[0].length-1];
      if(result > amount) return -1;
      return result;
       
    }
}