// Time Complexity : O(n * m)
// Space Complexity : O(n * m)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : took me a little time to figure out how to build the table

public class CoinChange1 {

    static int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int m = amount;
        int[][] dp = new int[n+1][m+1];

        for(int i = 1; i < m + 1; i++) {
            dp[0][i] = Integer.MAX_VALUE - 20;
        }
        for(int i = 0; i < n + 1; i++) {
            dp[i][0] = 0;
        }

        for(int i = 1; i < n+1; i++) {
            for(int j = 1; j < m + 1; j++) {
                if(j < coins[i-1]) {
                    dp[i][j] = dp[i-1][j];
                } else{
                    dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j - coins[i-1]]);
                }
            }
        }
        int sol = dp[n][m];
        if(sol >= Integer.MAX_VALUE - 20) return -1;
        return sol;
    }

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;

        System.out.println("Fewest number of coins needed to make the amount are :" + coinChange(coins, amount));
    }
}
