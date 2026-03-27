//Time Complexity: O(m * n), where m = amount, n = coins length
//Space Complexity: O(m), since we will store the min amount of coins required to form each amount from 0 -> m
//Did this code successfully run on Leetcode :Yes
//Approach: This problem can be solved using recursion or exhaustive approach and go through each and every denomination and amount (choose or not choose), however it will lead to TLE
//This can be optimized using DP, by storing the output for overlapping subproblems in an array and use that to compute the min coins required
//at every denomination, a particular amount when greater than the denomination can be computed by this formula min(current min to form the amount, 1 + dp[current index - denomination])
//for eg: when at denomination 2, amount 6 can be computed like min(6, 1 + dp[6 - 2]), dp[4] using [1, 2] will be formed by 2 coins, so the answer will be min(6, 1 + 2) = 3

/**
 * Finds and returns the minimum no of coins to form the given amount
 */
public class CoinChange {

    /**
     *
     * @param coins  the denominations to make up the amount
     * @param amount the amount of money to form through the denominations
     * @return       the minimum no of coins to form the amount
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE - 10; //to not get into integer overflow issues
        }

        for (int coin : coins) {
            for (int j = 1; j <= amount; j++) {
                if (coin <= j) {
                    dp[j] = Math.min(dp[j], 1 + dp[j - coin]);
                }
            }
        }

        if (dp[amount] == Integer.MAX_VALUE - 10) return -1;
        return dp[amount];
    }

    public static void main(String[] args) {
        final CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.coinChange(new int[] {1, 2, 5}, 11)); //return 3
        System.out.println(coinChange.coinChange(new int[] {1, 2, 5}, 13)); //return 4
        System.out.println(coinChange.coinChange(new int[] {2}, 3)); //return -1
        System.out.println(coinChange.coinChange(new int[] {1}, 0)); //return 0
    }
}
