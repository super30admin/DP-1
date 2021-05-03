// Time Complexity : O(NK) where N is length of coins and K is amount+1
// Space Complexity :O(NK) where N is length of coins and K is amount+1
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class CoinsChange {
    
  public int coinChange(int[] coins, int amount) {
 int max = amount + 1;
    int[][] dp = new int[coins.length+1][amount + 1];
   
      for(int i=0;i<dp.length;i++){
          dp[i][0]=0;   // fill first row with 0's as no min
      }
      
      for(int j=1;j<dp[0].length;j++){
          dp[0][j]=amount+1;  // fill first col with max or infinity for easier comupation. In our case we took amount+1 as amount can never exceed given amount
      }
   
    for (int i = 1; i <dp.length; i++) {
      for (int j = 0; j < dp[0].length; j++) {
        if (j < coins[i-1]) {  // check if coins is less than amount
         
            dp[i][j]=dp[i-1][j]; // since its less coin will not be considered
        }
          else{ // coin may or may not be considered. Take both cases and choose minimum
              dp[i][j]=Math.min(dp[i-1][j],dp[i][j-coins[i-1]]+1);
              
          }
      }
    }
      
      int res= dp[dp.length-1][dp[0].length-1];
      if(res>=amount+1) return -1; // no possible solution
    return dp[dp.length-1][dp[0].length-1]; // last element at matrix will have min
  }  
}