/*
 *  Time Complexity: O(N*M) Where N is the number of coins and M is the amount 
 *  Space Complexity: O(N*) Since we are creating a dp array with N*M dimensions
 * 
 *  Did this code successfully run on Leetcode : Yes
 *  Any problem you faced while coding this : None
 * 
 *  Create a dp array with rows equal to number coins+1 and columns equal to amount+1. Now the first row represent we have 0 coins and create the target amounts( represent by j), we populate the values with either (Integer.MAX_VALUE || amount+1 //to avoid integer overflow) . Now we can populate the remain rows by consider the minimum between (the value in row above || 1 + dp[i][substract the current targetSum(j) with the current coin value]//this represent the number of coins required if we take the current coin into consideration. In the last we return the last element in the dp array.
 */

class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins==null || coins.length==0) return -1;
        int dp[][]= new int[coins.length+1][amount+1];
        for(int i=0;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(i==0)
                    dp[i][j]=amount+1;
                else{
                    if(coins[i-1]>j)
                        dp[i][j]=dp[i-1][j];
                    else 
                        dp[i][j]=Math.min(dp[i-1][j], dp[i][j-coins[i-1]]+1 );
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1]>amount?-1:dp[dp.length-1][dp[0].length-1];
    }  
}
