/*
Runtime complexity - O(MN) - where N-number of coins, M - amount
Space Complexity - O(MN) - where N - number of coins, M- amount

This code ran successfully in leetcode
I have also added the brute force method in the bottom although it gave me time limit exceeded when i submitted.
*/

public class Solution {

  public int coinChange(int[] coins, int amount) {
    if (amount < 1) return 0;
    int[][] dp=new int[coins.length+1][amount+1];
      for(int j=1;j<dp[0].length;j++)
      {
          dp[0][j]=amount+1; // Max value or infinity works as well
      }
      for(int i=1;i<dp.length;i++)
      {
          for(int j=1;j<dp[0].length;j++)
          {
              if(coins[i-1]>j)
                  dp[i][j]=dp[i-1][j];
              else
                  dp[i][j]=Math.min(dp[i-1][j],dp[i][j-coins[i-1]]+1);
          }
      }
      
      if(dp[dp.length-1][dp[0].length-1]==amount+1)
          return -1;
      return dp[dp.length-1][dp[0].length-1];    
  }
}   

// Brute force method (Time limit exceeded)
    /*
    return helper(coins, amount,0,0);
    public int helper(int[] coins,int amount, int index, int min)
    {
        if(amount==0)
            return min;
        if(amount<0 || index==coins.length)
            return -1;
        int case1=helper(coins,amount-coins[index],index,min+1);
        int case2=helper(coins,amount,index+1,min);
        if(case1==-1)
            return case2;
        if(case2==-1)
            return case1;
        return Math.min(case1,case2);
    }*/
