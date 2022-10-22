// TC: O(nk) k is amount
// SC: O(k)
class Solution {

    private int[][] dp;

    public int coinChange(int[] coins, int amount) {
        dp = new int[coins.length][amount + 1];
        int totalCoin = recursion(coins, 0, amount);
        return totalCoin == Integer.MAX_VALUE ? -1 : totalCoin;
    }

    private int recursion(int[] coins, int index, int amount) {
        // base
        // valid
        if (amount == 0)
            return 0;

        // not valid
        if (amount < 0 || index == coins.length)
            return Integer.MAX_VALUE;
        if (dp[index][amount] == 0) {
            // recurse
            // select
            int select = recursion(coins, index, amount - coins[index]);
            if (select != Integer.MAX_VALUE)
                select += 1;
            // notselect
            int notSelect = recursion(coins, index + 1, amount);

            dp[index][amount] = Math.min(select, notSelect);
        }
        return dp[index][amount];
    }
}