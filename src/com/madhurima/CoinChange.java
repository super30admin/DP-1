/*
    Time Complexity = O(amount * coins)
    Space Complexity = O(amount * coins)
    Did this code successfully run on Leetcode : yes
*/

package com.madhurima;

public class CoinChange {
}

class SolutionA1 {
    public int coinChange(int[] coins, int amount) {

        if(coins == null || coins.length == 0 || amount < 0){
            return -1;
        }

        int n = coins.length;
        int[][] dp = new int[n+1][amount + 1];

        //fill first row from 2nd column i.e. from i=1 with infinity i.e. amount+1
        for(int i = 1; i < amount+1; i++){
            dp[0][i] = amount+1;
        }

        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < amount + 1; j++){
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-coins[i-1]] + 1);
                }

            }
        }

        if(dp[n][amount] == amount+1){
            return -1;
        }

        return dp[n][amount];

        // return helper(coins, amount, 0, 0);

    }

    //Recursion helper function
    private int helper(int[] coins, int amount, int idx, int coinsUsed){

        if(idx == coins.length || amount < 0){
            return -1;
        }

        if(amount == 0){
            return coinsUsed;
        }

        //case zero: not chosen
        int case1 = helper(coins, amount, idx+1, coinsUsed);

        //case one: chosen
        int case2 = helper(coins, amount - coins[idx], idx, coinsUsed+1);

        if(case1 == -1){
            return case2;
        }

        if(case2 == -1){
            return case1;
        }

        return Math.min(case1, case2);
    }

    public static void main(String[] args) {
        SolutionA1 s = new SolutionA1();
        int[] coins = {1,2,5};
        int target = 11;
        System.out.println(s.coinChange(coins, target));
    }


}
