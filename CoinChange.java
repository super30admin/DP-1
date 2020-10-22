package S30.DP_1;

// Time Complexity : Put: O(mn),  m is coins.length, n is amount
// Space Complexity : O(mn),  m is coins.length, n is amount
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class CoinChange {

    public int coinChange(int[] coins, int amount) {

        if(coins == null || coins.length == 0) return -1;

        int[][] dp = new int[coins.length+1][amount+1];
        int m = dp.length;
        int n = dp[0].length;
        //if number of coins are 0
        for(int j = 1; j < n; j++){
            dp[0][j] = Integer.MAX_VALUE-1;
        }

        //if amount is 0, no number of coins can make the amount
        for(int i = 0; i < m; i++){
            dp[i][0] = 0;
        }

        //don't include coin -> dp[coins-1][amount]
        //include coin -> 1 + dp[coins][amount - coins[i]]
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){

                //if it is possible to choose the coin
                if(coins[i-1] <= j){
                    dp[i][j] = Math.min(1 + dp[i][j - coins[i-1]], dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[m-1][n-1] >= Integer.MAX_VALUE-1 ? -1 : dp[m-1][n-1] ;
    }
}
