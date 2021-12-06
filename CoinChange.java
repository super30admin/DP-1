// Time Complexity :O(N^2)
// Space Complexity :O(coins.length)(amount) which will be similar to O(mn); where m is the length of coins array and n is the amount.
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this :NO




public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0 || coins == null) {
            return 0;

        }
        int dp[][] = new int[coins.length + 1][amount + 1];
        for (int j = 1; j < amount + 1; j++) {
            dp[0][j] = amount + 1;
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
        if (dp[coins.length][amount] > amount) {
            return -1;
        }
        return dp[coins.length][amount];
    }
    public static void main(String args[]){
        int coins[]={2,1,5};
        int amount=11;
        CoinChange obj=new CoinChange();
        System.out.println(obj.coinChange(coins, amount));
    }
}