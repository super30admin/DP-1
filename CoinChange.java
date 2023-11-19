// Time complexity: O(m * n); m -> amount, n -> no. of coins
// Space complexity: O(m); m -> amount
class CoinChange {
    int[] dp;
    public int coinChange(int[] coins, int amount) {
        if(amount < 0) return -1;
        dp = new int[amount + 1];

        dp[0] = 0;
        for(int i = 1; i <= amount; i++){
            dp[i] = Integer.MAX_VALUE;

            for(int coin: coins){
                if(i - coin >= 0 && dp[i - coin] != Integer.MAX_VALUE)
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        if(dp[amount] == Integer.MAX_VALUE) return -1;
        return dp[amount];
    }
}