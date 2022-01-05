// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
Bottom up DP

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        
        dp[0][0]=0;
        for(int j=0; j<dp[0].length; j++){
            dp[0][j]=amount+1;
        }
        for (int i=1; i<dp.length; i++){
            for(int j = 1; j<dp[0].length; j++){
                if(coins[i-1]<=j){
                    
                    //choose
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-coins[i-1]]+1);
                    //not to choose
                }else {
                      dp[i][j] = dp[i-1][j];
                }
            }
        }//if i dont get the solution the min value that will come to this location will be amount +1;
        int result = dp[dp.length -1][dp[0].length-1];
        if(result>amount){
            return -1;
        }else {
            return result;
        }
        
    }
}