// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
//## Problem1 (https://leetcode.com/problems/coin-change/)
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
public class CoinChange {
//    public int coinChange(int[] coins, int amount) {
//        //Recursion
//        return helper(coins,0,amount,0);
//    }
//    private int helper(int[] coins, int i, int amount, int coinUsed){
//        //base
//        if(i==coins.length || amount < 0) return -1;
//
//        if(amount == 0){
//            return coinUsed;
//        }
//
//        //logic
//        //not choose
//        int case0 = helper(coins, i+1, amount, coinUsed);
//
//        //choose
//        int case1 = helper(coins, i, amount-coins[i], coinUsed+1);
//        if(case0 == -1) return case1;
//        if(case1 == -1) return case0;
//        return Math.min(case0, case1);
//    }
    public int coinChange(int[] coins, int amount) {

        // int m = coins.length;
        // int n = amount;
        // int[][] dp = new int[m+1][n+1];

        // for(int j = 1; j <= n; j++){
        //     dp[0][j] = amount + 1;
        // }
        // for(int i = 1; i <= m; i++){
        //     for(int j = 1; j <= n; j++){
        //         if( j < coins[i-1])
        //             dp[i][j]=dp[i-1][j];
        //         else{
        //             dp[i][j] = Math.min(dp[i-1][j],1+dp[i][j-coins[i-1]]);
        //         }
        //     }
        // }
        // if(dp[m][n] == amount + 1) return -1;
        // return dp[m][n];
        int m = coins.length;
        int n = amount;
        int[] dp = new int[n+1];

        for(int j = 1; j <= n; j++){
            dp[j] = amount + 1;
        }
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if( j < coins[i-1])
                    dp[j]=dp[j];
                else{
                    dp[j] = Math.min(dp[j],1+dp[j-coins[i-1]]);
                }
            }
        }
        if(dp[n] == amount + 1) return -1;
        return dp[n];
    }
}
