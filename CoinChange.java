class Solution {
    public int coinChange(int[] coins, int amount) {
        int [] dp = new int[amount + 1];
        dp[0] = 0;
        for(int i = 1; i <= amount; i++ ) {
            dp[i] = Integer.MAX_VALUE;
        }
        for(int i = 1; i <= amount; i++) {
            for(int coin : coins) {
                if(i >= coin && dp[i - coin] != -1 && coin != 0 ){
                    //dp[i - coin] != -1 && coin != 0
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
            if(dp[i] == Integer.MAX_VALUE) {
                dp[i] = -1;
            }
        }
        return dp[amount] == Integer.MAX_VALUE? -1: dp[amount];
        
    }
}