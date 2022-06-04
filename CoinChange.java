// Time Complexity : O(amount)
// Space Complexity : O(amount)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[]dp = new int[amount+1];
        dp[0]=0;
        for(int i =1 ;i<dp.length;i++)
            dp[i]=amount+1;//9999
                                             
        for(int i =1;i<dp.length;i++)
           for(int c:coins)
               if(i-c>=0)
            dp[i]= Math.min(dp[i], 1+dp[i-c]);
    
    
     return dp[amount]==amount+1?-1:dp[amount];
    }
    
    
}