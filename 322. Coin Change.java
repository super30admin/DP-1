// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
public class Solution {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int n = amount;
        int[][] dp = new int[m+1][n+1];
        //top row
        for( int j=0;j<amount+1;j++){
            dp[0][j] = amount+1; //99999
        }
        //first row
        for( int i=1; i<dp.length;i++){
            for( int j = 1;j<dp[0].length;j++){
                if(coins[i-1]>j){
                    dp[i][j] =  dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.min(dp[i-1][j],1+dp[i][j-coins[i-1]]);
                }
                
            }
        }
        int result =  dp[dp.length-1][dp[0].length-1];
        if(result>amount){
            return -1;
        }
        return result;
  
  //       if(coins == null || coins.length == 0)return -1;
  //       int result = helper(coins,amount,0,0);
  //       return result;
  //   }
  //     int helper(int[] coins,int amount, int i, int coinsUsed){
  //         //base
  //         if(amount==0) return coinsUsed;
  //         if( amount<0|| i==coins.length) return -1;
          
  //         //logic
  //         //choose
  //         int case1 = helper(coins,amount-coins[i],i,1+coinsUsed);
  //         //not choose
  //         int case2 = helper(coins,amount,i+1,coinsUsed);
          
  //         if(case1==-1)return case2;
  //         if(case2==-1) return case1;
  //         return Math.min(case1,case2);
      }
  }