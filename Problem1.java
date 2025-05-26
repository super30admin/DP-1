// Time Complexity : O(m*n) where m = minCoins array length & n = coins array length
// Space Complexity : O(m) where m = minCoins array length
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : YES


class Problem1 {
    public int coinChange(int[] coins, int amount) {
        int[] minCoins = new int[amount + 1];
        Arrays.fill(minCoins, amount + 1);
        minCoins[0] = 0;

        for (int i = 1; i < minCoins.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0)
                    minCoins[i] = Math.min(minCoins[i], 1 + minCoins[i - coins[j]]);
            }
        }

        return minCoins[amount] > amount ? -1 : minCoins[amount];
    }
}