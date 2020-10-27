// Time Complexity : o(n x m)
// Space Complexity : o(n x m)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Leetcode : 322


class Solution {
    public int coinChange(int[] coins, int amount) {
        //edge 
        if(coins.length == 0 || coins == null) return -1; 
    
    //dp array of extra ith and jth index
    int[][] dp = new int[coins.length+1][amount+1];
     
    //fill first row with value greater than amount    
    for(int j = 1 ; j < dp[0].length ; j++){
            dp[0][j] = amount+1;
        }
    for(int i = 1 ; i < dp.length; i++){
            for(int j = 1 ; j < dp[0].length; j++){
                if(j<coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-coins[i-1]]+1);
                }
            }
        }
        if(dp[dp.length-1][dp[0].length-1]>amount){return -1;}
        return dp[dp.length-1][dp[0].length-1];
    }
}
