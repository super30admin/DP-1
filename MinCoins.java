import java.util.Arrays;

//Time Complexity: O(sn) where s the amount and n is the number of coins
//Space Complexity: O(s) where we store the min coin required for [0, s] amount range
//Did this code successfully run on Leetcode : Yes

/**
 * Using dynamic programming approach to start calculating minimum coins required to get the amount [0, s].
 * We store the result into an array to avoid calculating the previously calculated results which gets our time complexity from O(s^n) to O(sn)
 */
public class MinCoins {

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // setting max since we have to find the minimum number of coins at every point. Doing -10 to avoid integer overflow
        Arrays.fill(dp, Integer.MAX_VALUE - 10);

        // 0 coins required to make 0 amount
        dp[0] = 0;
        for (int i = 1 ; i <=amount;i++) {
            for (int coin : coins) {
                if (i - coin < 0) continue;
                dp[i] = Math.min(dp[i], dp[i-coin] + 1);
            }
        }

        return dp[amount] == Integer.MAX_VALUE - 10  ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1,2,5}, 11));
    }
}
