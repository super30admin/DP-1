// Time - O(N^M)
// Space - O(M)
// Ran on LeetCode
// No issues

import java.util.Arrays;

public class CoinChange {

    private static final int MAX = 10000;

    public static int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[max];
        Arrays.fill(dp, max);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                int coin = coins[j];
                if(i >= coin)
                    dp[i] = Math.min(1 + dp[i - coin], dp[i]);
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1, 2, 5}, 11)); // 3
    }

}
