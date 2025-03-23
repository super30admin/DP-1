// Time Complexity : O(n*m)
// Space Complexity : SC=O(m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach: 2 choices for each coin, choose or not choose, create dp matrix for better understanding of size (no of coins+1)*(amount+1). Initialize each column in first row to high no 999999 except [0][0] cell. Then loop through i frm 1 to i<= n and j from 0 to j<=m, if j<coins[i-1] means amt is higher than coin value so no choose case, then dp[i][j]=dp[i-1][j] else choose there have 2 choices no choose and choose, decide based max. dp[i][j] = max(dp[i-1][j], 1 + dp[i][j - coins[i-1]]), ans will be store bottom right of matrix i.e. dp[n][m]
//In optimal version, instead of matrix dp[] is used, no change value is at same place and that cell gets updated for next iteration, saves space due to [] array. but same time complexity

public class CoinChange {
//    Approach 1- Dynamic programming - bottom up - tabulation      TC=O(n*m), SC=O(n*m)
    // public int coinChange(int[] coins, int amount) {
    //     int n = coins.length;
    //     int m = amount;
    //     int[][] dp = new int[n+1][m+1];
    //     for(int j = 1; j <= m; j++) {
    //         dp[0][j] = 999999;
    //     }

    //     for(int i = 1; i <= n; i++) {
    //         for(int j = 0; j <= m; j++) {
    //             if(j < coins[i-1]) {  //if amount is less than denomination then don't choose that coin
    //                 dp[i][j] = dp[i-1][j];
    //             } else {
    //                 //choose case
    //                 dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j - coins[i-1]]);
    //             }
    //         }
    //     }
    //     if(dp[n][m] == 999999)  return -1;
    //     return dp[n][m];
    // }

    //    Approach 2- Optimized Dynamic programming - bottom up - tabulation    TC=O(n*m), SC=O(m)
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int m = amount;

        int[] dp = new int[m+1];

        for(int j = 1; j <=m; j++) {
            dp[j] = 999999;
        }
        dp[0] = 0;

        for(int i = 1; i <= n; i++) {
            for(int j = 0; j <= m; j++) {
                if(j >= coins[i - 1]) { //if amount is greater or equal to coin value then only have option to choose
                    dp[j] = Math.min(dp[j], 1 + dp[j - coins[i-1]]);
                }
            }
        }
        if(dp[m] == 999999) {
            return -1;
        } else {
            return dp[m];
        }
    }

    public static void main(String[] args) {
        CoinChange solver = new CoinChange();

        int[] coins1 = {1, 2, 5};
        int amount1 = 11;
        System.out.println("Coins: [1, 2, 5], Amount: 11, Result: " + solver.coinChange(coins1, amount1));

        int[] coins2 = {2};
        int amount2 = 3;
        System.out.println("Coins: [2], Amount: 3, Result: " + solver.coinChange(coins2, amount2));

    }
}
