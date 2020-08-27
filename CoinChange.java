// Time Complexity : O(n*m) where n is the length of coins and m is the amount
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Implemented solution explained in class

//Implemented the tabulation method of storing previous values and using it to update current values with minimum coins at each index


class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int[][] dp=new int[coins.length+1][amount+1];
        for(int i=0;i<=coins.length;i++){
            dp[i][0]=0;
        }
        for(int j=0;j<=amount;j++){
            dp[0][j]=99999;
        }
        for(int i=1;i<=coins.length;i++){
            for(int j=1;j<=amount;j++){
                if(coins[i-1]>j){
                    dp[i][j]=dp[i-1][j];
                }
                else{
                dp[i][j]=Math.min(dp[i-1][j],1+dp[i][j-coins[i-1]]);
                }
            }
        }
        return dp[coins.length][amount]>=99999 ? -1:dp[coins.length][amount];
    }
}