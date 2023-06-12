// Time Complexity : O(mn)
// Space Complexity : O(n+m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//we are building a 2d dp arrray to avoid repeated sub problems , we have fill the first row with max values. 
// till the value of the coin is more than amount copy the value of above row. 
// else we find the min of the above value or the value of the coin steps back in the same row. 


class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || amount == 0) return 0;
       int dp[][] = new int[coins.length+1][amount+1];
       for(int i=1;i<=amount;i++)
       {
           dp[0][i] = 99999;
       }
       for(int i=1;i<=coins.length;i++)
       {
           for(int j=0;j<=amount;j++)
           {
               if(coins[i-1] > j) 
               {
                   dp[i][j]= dp[i-1][j];
               }
               else 
                   dp[i][j]= Math.min(dp[i-1][j], 1+dp[i][j-coins[i-1]]);
           }
       } 
       if(dp[coins.length][amount]>=99999) return -1;
       else return dp[coins.length][amount];
    }
}