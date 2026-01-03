/*
COIN CHANGE I (LeetCode 322)

Problem:
Given coin denominations and a target amount, return the minimum number of coins
required to make that amount. If it is not possible, return -1.

This class demonstrates FOUR different approaches to solve the problem,
starting from brute force recursion and gradually optimizing to Dynamic Programming.

Approaches implemented:
1. Pure Recursive (Brute Force)            -> Exponential Time
2. Top-Down DP (Recursion + Memoization)  -> O(coins * amount)
3. Bottom-Up DP (2D Table)                -> O(coins * amount)
4. Bottom-Up DP (1D Optimized)             -> O(coins * amount), Space O(amount)
*/

public class CoinChange {

    // Used for memoization in Top-Down DP
    int[][] memo;

    /*1. PURE RECURSIVE SOLUTION (BRUTE FORCE)
       Try all possibilities:
       - Either skip the current coin
       - Or take the current coin and reduce the amount
       Time Complexity: Exponential (very slow)
       Space Complexity: Recursion stack
    */
    public int recursiveCoinChange(int[] coins, int amount) {
        int result = recursiveHelper(coins, amount, 0);
        return (result >= Integer.MAX_VALUE - 10) ? -1 : result;
    }

    private int recursiveHelper(int[] coins, int amount, int idx) {
        // Base cases
        if (amount == 0) return 0;
        if (idx == coins.length || amount < 0) return Integer.MAX_VALUE - 10;

        // Choice 1: Do not take current coin
        int notChoose = recursiveHelper(coins, amount, idx + 1);

        // Choice 2: Take current coin (unbounded)
        int choose = recursiveHelper(coins, amount - coins[idx], idx);

        return Math.min(notChoose, choose);
    }

    /* 2. TOP-DOWN DP (MEMOIZATION)
       Same recursive logic, but we store results for each state
       (idx, amount) to avoid recomputation.
       Time Complexity: O(coins * amount)
       Space Complexity: O(coins * amount)
    */
    public int coinChangeTopDown(int[] coins, int amount) {
        memo = new int[coins.length][amount + 1];
        int result = topDownHelper(coins, amount, 0);
        return (result >= Integer.MAX_VALUE - 10) ? -1 : result;
    }

    private int topDownHelper(int[] coins, int amount, int idx) {
        if (amount == 0) return 0;
        if (idx == coins.length || amount < 0) return Integer.MAX_VALUE - 10;

        if (memo[idx][amount] != 0) {
            return memo[idx][amount];
        }

        int notChoose = topDownHelper(coins, amount, idx + 1);
        int choose = 1 + topDownHelper(coins, amount - coins[idx], idx);

        memo[idx][amount] = Math.min(notChoose, choose);
        return memo[idx][amount];
    }

    /* 3. BOTTOM-UP DP (2D TABLE)
       dp[i][j] = minimum coins needed to make amount j
                  using first i coin types
       Time Complexity: O(coins * amount)
       Space Complexity: O(coins * amount)
    */
    public int coinChange2D(int[] coins, int amount) {
        int m = coins.length;
        int INF = 99999;

        int[][] dp = new int[m + 1][amount + 1];

        // Base case: no coins, positive amount impossible
        for (int j = 1; j <= amount; j++) {
            dp[0][j] = INF;
        }

        // Fill DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j]; // cannot take coin
                } else {
                    dp[i][j] = Math.min(
                            dp[i - 1][j],               // skip coin
                            1 + dp[i][j - coins[i - 1]] // take coin
                    );
                }
            }
        }

        return dp[m][amount] == INF ? -1 : dp[m][amount];
    }

    /* 4. BOTTOM-UP DP (1D OPTIMIZED)
       dp[j] = minimum coins needed to make amount j
       Optimizes space by reusing previous results.
       Time Complexity: O(coins * amount)
       Space Complexity: O(amount)
    */
    public int coinChange1D(int[] coins, int amount) {
        int INF = 99999;
        int[] dp = new int[amount + 1];

        dp[0] = 0;
        for (int j = 1; j <= amount; j++) {
            dp[j] = INF;
        }

        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] = Math.min(dp[j], 1 + dp[j - coin]);
            }
        }

        return dp[amount] == INF ? -1 : dp[amount];
    }
}
