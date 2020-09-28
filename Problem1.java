// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0 || coins.length==0)
            return 0;
        
        int[] dp = new int[amount+1];
        dp[0]=0;//mark the first element as zero
        
        for(int amt=1;amt<=amount;amt++)
        {
            dp[amt] =amount+1; //mark the last element as amount+1
            for(int coin:coins)
            {
                if(coin <= amt) //if the given coin is less than the amt in the array
                {
                   dp[amt]=Math.min(1+dp[amt-coin],dp[amt]) ; // calculate the minimum amount by checking the previous coin and the current amt
                }                
            }
        }
        return dp[amount] >amount?-1:dp[amount];
    }
}