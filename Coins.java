/*this implementation uses dynamic programming approach to determine the minimum coins needed
* the time complexity of this approach is O(amount * n)*/
import java.util.Arrays;

public class Coins {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int c : coins) {
                if (c <= i && dp[i-c] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i-c] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        Coins coins1 = new Coins();
        int minCoins = coins1.coinChange(coins, amount);
        System.out.println("Minimum number of coins needed: " + minCoins);
    }
}
