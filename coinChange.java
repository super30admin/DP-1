// Time Complexity : O (m * n)  where m is number of rows, n is number of columns
// Space Complexity : O (m * n) for the dp matrix
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

public class coinChange {

    public static int coinChangeFn(int[] coins, int amount) {
        if(coins == null || coins.length == 0) return -1;
        int [][] dp = new int[coins.length + 1][amount + 1];

        for(int j = 0; j < dp[0].length; j++){
            dp[0][j] = amount + 1;
        }

        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(j < coins[i - 1]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j - coins[i-1]]);
                }
            }
        }
        if(dp[dp.length - 1][dp[0].length - 1] > amount) return -1;
        return dp[dp.length - 1][dp[0].length - 1];

    }

    public static void main(String []args){
        int [] coins = {1, 2, 5};
        int amount = 11;
        int result = coinChangeFn(coins, amount);

    }
    
}
