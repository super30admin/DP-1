
// Time Complexity : O(N * A) where N is length of coins array and A is amount
// Space Complexity : O(N * A) where N is length of coins array and A is amount
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :Yes


// Your code here along with comments explaining your approach

public class CoinChange {
    public static void main(String args[]) {
        int[] coins = {1,2,5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));
    }

    private static int coinChange(int[] coins, int amount) {
        if(coins == null){
            return 0;
        }
        int[][] dp = new int[coins.length + 1][amount + 1];

        for(int i=0; i<dp[0].length; i++){
            dp[0][i] = amount + 1;
        }

        dp[0][0] = 0;

        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                if(j < coins[i - 1]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j - coins[i - 1]] + 1);
                }
            }
        }
        int res = dp[dp.length - 1][dp[0].length - 1];

        return res > amount ? -1 :  res;
    }
}
