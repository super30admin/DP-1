//Time Complexity O(M*N)
//Space Complexity O(M*N)
// where m = size of coins and n = amount
public class Problem1 {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) return -1;
        int[][] dp = new int[coins.length + 1][amount + 1];

        for (int i = 1; i < amount + 1; i++) {
            dp[0][i] = amount + 1;
        }
        for (int i = 1; i < coins.length + 1; i++) {
            for (int j = 1; j < amount + 1; j++) {
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                }
            }
        }
        if (dp[coins.length][amount] == amount + 1) return -1;
        return dp[coins.length][amount];

    }

    public int coinWithRecusrion(int[] coins, int amount) {
        if (coins == null || coins.length == 0) return -1;

        return helper(coins, amount, 0, 0);

    }

    private int helper(int[] coins, int amount, int index, int coinUsed) {
        if (amount == 0) {
            return coinUsed;
        } else if (amount < 0 || index == coins.length) {
            return -1;
        }
        //logic
        // zero do not choose case
        int case1 = helper(coins, amount, index + 1, coinUsed);
        //one or choose case
        int case2 = helper(coins, amount - coins[index], index + 1, coinUsed + 1);

        if (case1 == -1) {
            return case2;
        }
        if (case2 == -1) {
            return case1;
        }
        return Math.max(case1, case2);
    }

    public static void main(String[] args) {
        int[] coins = {5, 2, 1};
        int[] coins1 = {1, 2, 3, 8, 7, 4};
        Problem1 problem1 = new Problem1();
        int result = problem1.coinWithRecusrion(coins1, 10);
        System.out.println("Final result " + result);
    }
}
