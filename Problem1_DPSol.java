//Coin change
class Problem1_DPSol {
    public int coinChange(int[] coins, int amount) {
      //edge
      if(coins==null ||coins.length == 0) return -1; 
      int [][] dp = new int[coins.length+1][amount+1];
      int m = dp.length;
      int n = dp[0].length;
      for(int i=1; i<n; i++)
      dp[0][i] = amount+1;
      for(int i=1; i< m; i++){
        for(int j= 1; j< n ; j++){
          if(j<coins[i-1])
            dp[i][j]= (dp[i-1][j]);
          else{
            dp[i][j]= Math.min(dp[i-1][j], 1+dp[i][j-coins[i-1]]);
          }
        }
      }
      int result = dp[m-1][n-1];
      if(result>=amount+1) return -1;
      return result;
  
    }
}
/*
Time Complexity : O(mXn) 
m = coins
n = amount

Space Complexity : O(mXn)

Did this code successfully run on Leetcode : Yes

Any problem you faced while coding this : No

Your code here along with comments explaining your approach
- The optimization of the repeated subproblems in recursive approach
- A dp matrix(2d array) is constructed solutions for subproblems using the results obtained
in previously computed sub problems
- The last element of the 2d array is returned as the min number of coins.
*/
