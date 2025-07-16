//Time Complexity:O(m * n) - where m = number of coins, n = amount.we iterate through each coin and for each amount up to n.
//Space Complexity:O(n) - uses a 1D dp array of size n + 1.

//Initialize a dp array of size amount + 1 with a large number, except dp[0] = 0 (0 coins needed to make amount 0).
//For each coin, iterate over all amounts and update dp[j] = min(dp[j], 1 + dp[j - coin]) if the coin can contribute.
//Return dp[amount] if it's updated, else return -1 (amount can't be formed).

class Solution {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int n = amount;

        int[] dp = new int[n + 1];

        for (int j = 1; j <= n; j++) {
            dp[j] = 99999;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (j < coins[i - 1]) {
                    dp[j] = dp[j];
                } else {
                    dp[j] = Math.min(dp[j], 1 + dp[j - coins[i - 1]]);
                }
            }
        }

        if (dp[n] == 99999) return -1;
        return dp[n];
    }
}
