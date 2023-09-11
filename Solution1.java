// Leetcode Problem : https://leetcode.com/problems/coin-change/description/
// Time Complexity : O(n*m) where n is the total number of coins and m is the total amount
// Space Complexity : O(m) where m is the total amount
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * I create a single dimensional dp[amount+1] array and store all the values as amount+1 
 * initially. I iterate over the dp array as many times as there are total number of coins.
 * If coins[i] <= j I set dp[j] as the minimum of dp[j] and 1 + dp[j-coins[i]].
 * If the last element of dp array is still equal to amount+1 I return -1 else I'll return the last element.
 */
class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount+1];
        for(int i=1;i<dp.length;i++)
        {
            dp[i]=amount+1;
        }
        for(int i=0;i<coins.length;i++)
        {
            for(int j=1;j<dp.length;j++)
            {
                if(coins[i]<=j)
                {
                    dp[j] = Math.min(dp[j],1+dp[j-coins[i]]);
                }
            }
        }
        if(dp[amount]>amount)
        {
            return -1;
        }
        return dp[amount];
    }
}