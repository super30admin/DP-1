// Time Complexity : O(nk) where k is the types of coins
// Space Complexity : Not sure.
// Did this code successfully run on Leetcode : Yes.
// Any problem you faced while coding this : No.

class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0) return -1;
        int [][] dp = new int[coins.length + 1][amount + 1];
        int m = dp.length;
        int n = dp[0].length;
        
        for(int i = 0;i < m; i++){
            dp[i][0] = 0;
        }
        for(int i = 1;i < n; i++){
            dp[0][i] = Integer.MAX_VALUE - 1;
        }
        
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(j < coins[i - 1]){
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
                }
            }
        }
        int result = dp[m - 1][n - 1];
        if(result == Integer.MAX_VALUE - 1) return - 1;
        return result;
    }
}