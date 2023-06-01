// ## Problem1 (https://leetcode.com/problems/coin-change/)
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int dp[][] = new int[coins.length + 1][amount + 1];
        dp[0][0] = 0;

        for (int j = 1; j <= amount; j++) {
            dp[0][j] = Integer.MAX_VALUE / 2;
        }

        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                }
            }
        }
        if (dp[coins.length][amount] >= Integer.MAX_VALUE / 2) {
            return -1;
        }
        return dp[coins.length][amount];
    }

    public static void main(String[] args) {
        CoinChange obj = new CoinChange();
        int[] arr = { 1, 2, 5 };
        int[] arr2 = { 2 };
        System.out.println("Number of coins to reach amount 11 for input arr1: " + obj.coinChange(arr, 11));
        System.out.println("Number of coins to reach amount 3 for input arr2: " + obj.coinChange(arr2, 3));
    }
}