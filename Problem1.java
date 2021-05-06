// Time Complexity :O(m*n) m is length of coins and n is amount given
// Space Complexity :O(m*n) m is length of coins and n is amount given
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
//Dynamic Programming 

class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins==null || coins.length==0) return -1;
        int[][] dp= new int[coins.length+1][amount+1];
        for(int j=1;j<dp[0].length;j++){
            dp[0][j]=amount+1;
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(coins[i-1]>j){
                    dp[i][j]=dp[i-1][j];
                }else{
                dp[i][j]=Math.min(dp[i-1][j], dp[i][j-coins[i-1]]+1);
                }
            }
        }
        if(dp[dp.length-1][dp[0].length-1]==amount +1) return -1;
        return dp[dp.length-1][dp[0].length-1];
    }
} 