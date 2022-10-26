// Time Complexity : O(2^amount)
// Space Complexity : O(no of coins * amount)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach\

import java.util.*;

public class Problem1 {
    public static int[][] dp;

    public static int coinChange(int[] coins, int amount) {
        dp = new int[coins.length][amount + 1];
        return coinChange(coins, amount, 0) == Integer.MAX_VALUE ? -1 : coinChange(coins, amount, 0);
    }

    public static int coinChange(int[] coins, int amount, int index) {
        // base

        if (amount == 0) {
            return 0;
        }

        if (amount < 0 || index == coins.length) {
            return Integer.MAX_VALUE;
        }

        // recurse

        if (dp[index][amount] == 0) {
            int select = coinChange(coins, amount - coins[index], index);
            if (select != Integer.MAX_VALUE) {
                select++;
            }

            int notSelect = coinChange(coins, amount, index + 1);
            dp[index][amount] = Math.min(select, notSelect);
        }
        return dp[index][amount];

    }

    public static void main(String[] args) {
        int[] coins = new int[] { 1, 2, 5 };
        int amount = 11;
        System.out.println(coinChange(coins, amount));
    }
}
