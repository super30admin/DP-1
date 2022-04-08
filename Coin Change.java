// Time Complexity : O(m*n) where m is the total number of coins and n is the total amount of money
// Space Complexity : O(m*n) where m is the total number of coins and n is the total amount of money
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins==null||coins.length==0)
            return 0;
        int [][] dp = new int[coins.length+1][amount+1];
        for(int i = 0;i<coins.length+1;i++){
            for(int j = 1;j<amount+1;j++){
                if(i==0){
                    dp[i][j] = amount+1;
                }
                else{
                    if(j<coins[i-1])
                        dp[i][j]=dp[i-1][j];
                    else
                        dp[i][j] = Math.min(1+dp[i][j-coins[i-1]],dp[i-1][j]);
                }
            }
        }
        if(dp[coins.length][amount]==amount+1)
            return -1;
        return dp[coins.length][amount];
    }
}