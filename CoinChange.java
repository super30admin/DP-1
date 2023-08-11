// Time Complexity : O(m*n)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Using DP and a 2D arr because there are 2 conditions our solution depends on.
// I add a dummy row and column and fill it with amt+1 since this value will never be reached.
// Case 0 will be chosen while the amount is lower than the value of the current 
// coins[i]. After, the minimum between case 0 or case 1 will be chosen.

class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0) return 0;
        int m = coins.length; //rows
        int n = amount; //columns
        int [][] dp = new int[m+1][n+1]; //add 1 for dummy val
        //first row
        for(int j = 1; j <= n; j++){
            dp[0][j] = amount + 1; //this val will never be reached
        }
        //start at 1 bc 0,0 is the dummy val
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j< dp[0].length ;j++){
                //until amount is smaller than denom
                if(j<coins[i-1]){
                    //case 0
                    dp[i][j] = dp[i-1][j];
                }else{
                    //choose min between case above or denom steps back
                    dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j-coins[i-1]]);
                }
            }
        }
        if(dp[m][n] > amount) return -1;
        return dp[m][n];
    }
}