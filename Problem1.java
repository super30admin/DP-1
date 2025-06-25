// Time Complexity : O(coins.length*amount)
// Space Complexity : O(coins.length*amount)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class Problem1 {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length+1][amount+1];
        dp[0][0] = 0;

        for(int i = 1; i <= amount; i++){
            dp[0][i] = Integer.MAX_VALUE - 10;
        }

        for(int i = 1; i <= coins.length; i++){
            for(int j = 1; j <= amount; j++){
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j-coins[i-1]]);
                }
            }
        }
        if(dp[coins.length][amount] == (Integer.MAX_VALUE - 10)) return -1;
        return dp[coins.length][amount];
    }
}