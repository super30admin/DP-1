// Time Complexity : O(nxm)
// Space Complexity :O(nxm)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

//322. Coin Change
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0) return -1;
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        for (int i = 1; i < amount + 1; i++){
            dp[0][i] = amount + 1;
            //filling with infinity
        }
        for(int i = 1; i < n + 1; i++){
            for (int j = 1; j < amount + 1; j++){
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-coins[i-1]] + 1);
                }
            }
        }
        if(dp[n][amount] == amount+1){
            return -1;
        }
        return dp[n][amount];
    }
}