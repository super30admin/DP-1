//Coin Change
//Time Complexity: O(m*n) where m is the amount and n is the number of coins
//Space Complexity: O(m) where m is the amount

public class CoinChange {
    int dp[];
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        dp = new int[max];

        dp[0] = 0;
        for(int i = 1; i <= amount; i++) {
            dp[i] = max;
        }

        for(int i = 1; i <= coins.length; i++) {
            for (int amt=1; amt<= amount; amt++) {
                if(amt >= coins[i-1]) {
                    dp[amt] = Math.min(1 + dp[amt - coins[i - 1]], dp[amt]);
                }
            }
        }
        return dp[amount] == max ? -1 : dp[amount];
    }
}
