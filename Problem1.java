Time Complexity: O(mn). m is number of coins and n is amount.
Space Complexity: O(mn). DP array. m is number of coins and n is amount.
Ran successfully on leetcode?: yes


class Solution {
    public int coinChange(int[] coins, int amount) {
        
        if(coins.length == 0 || amount < 0) return -1;
        
        int[][] dp = new int[coins.length + 1][amount + 1];
        int numberOfCoins = 0;
        
        for(int i = 1; i <= amount; i++){
            dp[0][i] = amount + 1;
        }
        
        for(int i = 1; i <= coins.length; i++){
            for(int j = 1; j <= amount; j++){
                if(j < coins[i - 1])
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j - coins[i - 1]] + 1);
            }
        }
        
        if(dp[coins.length][amount] == amount + 1) return -1;
        return dp[coins.length][amount];
    }
}
