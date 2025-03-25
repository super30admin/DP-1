public class CoinChangeRecursion {
    public int coinChange(int[] coins, int amount) {
        int result = helper(coins, amount, 0, 0);
        if (result == Integer.MAX_VALUE)
            return -1;

        return result;
    }

    private int helper(int[] coins, int amount, int i, int count) {
        if (amount < 0 || i == coins.length)
            return Integer.MAX_VALUE;

        if (amount == 0)
            return count;

        // No Choose
        int case0 = helper(coins, amount, i + 1, count);

        // choose
        int case1 = helper(coins, amount - coins[i], i, count + 1);

        return Math.min(case0, case1);
    }

}
//Used Recursion
// TC: O(2^m+n), SC: O(m+n)

