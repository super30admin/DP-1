import java.util.Arrays;

/**
 * Leet Code : https://leetcode.com/problems/coin-change/description/
 *
 * Approach:
 * This is a recursive solution with memoization (top-down dynamic programming).
 * For each coin, you can either pick it (and reduce the amount) or skip it (move to the next coin).
 * The function recursively tries both options and stores the result in a memo table to avoid recomputation.
 *
 * Time Complexity: O(N * A), where N = number of coins, A = amount. Each subproblem is solved once.
 * Space Complexity: O(N * A) for the memoization table.
 */
public class CoinChange {

    int[][] memo;

    public int coinChange(int[] coins, int amount) {
        memo = new int[coins.length][amount + 1];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }

        int count = recursive(coins, 0, amount);
        if (count < Integer.MAX_VALUE - 100)
            return count;
        else
            return -1;
    }

    public int recursive(int[] coins, int index, int amount) {
        if (amount < 0 || index >= coins.length) return Integer.MAX_VALUE - 100; // Not possible
        if (amount == 0) return 0; // No coins needed

        if(memo[index][amount] != -1) return memo[index][amount];
        // Try not picking or picking the current coin
        int notPick = recursive(coins, index + 1, amount);
        int pick = 1 + recursive(coins, index, amount - coins[index]);
        int minCount = Math.min(notPick, pick);
        memo[index][amount] = minCount;

        return minCount;
    }

    public static void main(String[] args) {
        System.out.println(new CoinChange().coinChange(new int[]{1, 2, 5}, 11));
    }
}
