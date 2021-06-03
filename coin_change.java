// Time complexity - O(m x n)
// Space complexity - O(m x n)
// Code accepted on leetcode!

class Solution {
    public int coinChange(int[] coins, int amount) {
       if(coins.length == 0)
           return -1;
        int[][] dp = new int[coins.length + 1][amount + 1];
        for(int i=0; i<coins.length; i++){
            dp[i][0] = 0;
        }
        for(int j=1; j<amount+1; j++){
            dp[0][j] = amount + 1; // infinity
        }
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                if(coins[i-1] > j){
                    dp[i][j] = dp[i-1][j];
                }
                else
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j - coins[i-1]]);
            }
        }
        int res = dp[coins.length][amount];
        if(res > amount)
            return -1;
        else
            return res;
        
    }
}
