
// Time Complexity :o(MN)
// Space Complexity :0(MN)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
   /* //Recursive Solution
    public int coinChange(int[] coins, int amount) {
        
       if(coins.length==0 || coins==null)
           return 0;
        
        return helper(coins,amount,0,0);
    }
    
    private int helper(int[] coins,int amount,int index,int min)
    {
        if(amount==0)
            return min;
        
        if(amount < 0 || index >= coins.length)
            return -1;
        
       // if we consider
        int case1=helper(coins,amount-coins[index],index,min+1);
        
        // if we dont consider
        int case2=helper(coins,amount,index+1,min);
        
        if(case1==-1)
            return case2;
        if(case2==-1)
            return case1;
        
        return Math.min(case1,case2);
    }
    */ 
     // DP Approach
     public int coinChange(int[] coins, int amount) {
         
         if(coins.length==0 ||coins==null)
             return 0;
         
         int[][] dp=new int[coins.length+1][amount+1];
         
         for(int j=1;j<=amount;j++)
         {
             dp[0][j]=amount+1;
         }
         
         for(int i=1;i<=coins.length;i++)
         {
             for(int j=1;j<=amount;j++)
             {
                 //current amount(j)< denominaation (i)
                 if(j<coins[i-1])
                     dp[i][j]=dp[i-1][j];
                 else
                     // choose or dont choose
                     dp[i][j]=Math.min(dp[i-1][j],dp[i][j-coins[i-1]]+1);
                 
             }
         }
         return dp[coins.length][amount] == amount+1 ? -1 : dp[coins.length][amount];
     }
}
