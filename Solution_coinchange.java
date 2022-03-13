/*
//Time Complexity :  O(n * m) , here n and m is the number of row and number of column in dp matrix.

//Space Complexity :  O(n * m) here n and m is the number of row and number of column in dp matrix.

// Did this code successfully run on Leetcode : Yes, worked on the leetcode

// Any problem you faced while coding this : I had faced challenge in created a condition 
for the choose case and at last I forgot to check for the if we didn't get minimum coin then return -1.

*/

public class Solution_coinchange {

    public int coinChange(int[] coins, int amount) {

        return helper(coins, amount, 0, 0);

    }

    private int helper(int[] coins, int amount, int index, int count) {

        // creating dp array with adding one more size for if our coins has only 1
        // value.

        int[][] dp = new int[coins.length + 1][amount + 1];

        // we can't get any amount with any coin so adding maximum amount.

        for (int j = 1; j < dp[0].length; j++) {

            dp[0][j] = amount + 1;

        }

        // Itreating throught the dp array.

        for (int i = 1; i < dp.length; i++) {

            for (int j = 1; j < dp[0].length; j++) {

                // checking if amount is >= then coin
                if (j >= coins[i - 1]) {

                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                }
                // if amount is < coin then just use value above that row and same column.
                else {

                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // checking if last element value has grether than amount then returning -1 else
        // value.
        return dp[dp.length - 1][dp[0].length - 1] == amount + 1 ? -1 : dp[dp.length - 1][dp[0].length - 1];

    }

}
