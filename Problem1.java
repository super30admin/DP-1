//Time Complexity O(M*N)
//Space Complexity O(M*N)
// where m = size of coins and n = amount
public class Problem1 {
    public static int coinChange(int[] coins, int amount) {
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
    public static void main(String[] args){
        int[] coins = {1,2,5};
        int result = Problem1.coinChange(coins, 11);
        System.out.println("Final result " + result);
    }
}
