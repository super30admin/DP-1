// Time Complexity :exponential
// Space Complexity :exponential
// Did this code successfully run on Leetcode :TLE
// Any problem you faced while coding this :was not able to visualize recursion earlier
class Solution {
    public int coinChange(int[] coins, int amount) {
        return helper(coins, amount, 0, 0);

    }

    public int helper(int[] coins, int amount, int index, int result) {
        // base case
        if (amount == 0) {// if amount reached the reqiured amt, return no of coins
            return result;
        }
        if (index >= coins.length || amount < 0)// if amt became -ve or we are past coins array length return -1
            return -1;

        // logic
        int case1 = helper(coins, amount - coins[index], index, result + 1);// we choose the coin
        int case2 = helper(coins, amount, index + 1, result);// we don't choose the coin
        if (case1 == -1)
            return case2;
        if (case2 == -1)
            return case1;
        else {
            return Math.min(case1, case2);// return minimum if both are valid
        }
    }
}

// --------------------OPTIMIZED---------------------
// Time Complexity :O(m*n)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];// make a 2d array
        dp[0][0] = 0;// in first index of first row, insert 0
        for (int i = 1; i <= amount; i++) {
            dp[0][i] = 99999;// in first row ie for 0 coin design,
        }

        for (int i = 1; i <= coins.length; i++) {// for all rest cells, we'll take minimum of previous row calculation
                                                 // and current calculation

            for (int j = 0; j <= amount; j++) {
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
                }
            }
        }

        if (dp[coins.length][amount] >= 99999) {// if last value is infinite ie 99999 that means,we cannot make amount
                                                // from given coins
            return -1;
        }
        return dp[coins.length][amount];// else return result
    }
}
