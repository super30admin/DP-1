// Time Complexity = O(n x m);
// Space Complexity = O(n x m);
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
public class CoinChange {
// Dynamic Programming
    // Time Complexity = O(n x m);
    // Space Complexity = O(n x m);
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0) return 0;
        int n = coins.length; // rows
        int m = amount; // columns

        // create a 2-d dp matrix, because we have 2 constants here (1. coin denominations and 2. amount)
        // to have 0 amount and 0 denomination we need to increase matrix row and column by 1
        int[][] dp = new int[n+1][m+1];

        // fill first row of matrix with Integer.MAX_VALUE, because we have to make amount 0 with 0 coin denomnation, which is not possible so infinity
        for(int j = 0; j< dp[0].length; j++){
            dp[0][j] = amount+1; // any number greater tha amount should work here
        }

        // now fill dp matrix
        // As row 0 is already filled, we wil start from 1st
        for(int i = 1; i < dp.length; i++){ // coin denomination index
            // coulmn has amount, and it starts from 0 (anount 0), which is not possible so starting from 1 here as well
            for(int j = 1; j < dp[0].length; j++){ // amount index
                // there will be some case when case1 (means using current coin is not possible), so we will be using only case0 there
                // such cases are when the amount is smaller than current coin denomination
                // j is amount here
                if(j < coins[i-1]){
                    // case0 where we will not be using current coin, so values will just be picked from one row above
                    dp[i][j] = dp[i-1][j];
                } else {
                    // case1 -> In here we will be taking min of (value from just above and amountIndex - (coin denomination + 1(because we have used 1 coin)) )
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j - coins[i-1]] + 1);
                }
            }
        }
        // all done here

        // Now check for invalid cases, and return -1
        if(dp[n][m] > amount){
            return -1;
        }
        return dp[n][m];
    }

// Exhaustive Approach
// TimeLimitExceeded Solution
    // public int coinChange(int[] coins, int amount) {
    //     // TimeLimitExceeded Solution
    //     if(coins == null || coins.length == 0) return 0;
    //     return helper(coins, amount, 0, 0);
    // }

    // private int helper(int[] coins, int amount, int coinPointer, int totalCoinsUsed){
    // // base
    //     // if we are left with no coins OR amount overshot (negative amount left)
    //     if(coinPointer == coins.length || amount < 0){
    //         return -1;
    //     }
    //     // if nothing is left then just return the totalCoinsUsed
    //     if(amount == 0){
    //         return totalCoinsUsed;
    //     }
    // // logic
    //     // case0, where we dont choose current coin
    //     int case0 = helper(coins, amount, coinPointer+1, totalCoinsUsed);

    //     // case1, where we choose current coin
    //     int case1 = helper(coins, amount - coins[coinPointer], coinPointer, totalCoinsUsed + 1);

    //     // if any of the solution returns -1 (invalid case) then return other case
    //     if(case1 == -1) return case0;
    //     if(case0 == -1) return case1;

    // // return min coins used of both cases
    //     return Math.min(case0, case1);
    // }

}
