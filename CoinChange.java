// Time Complexity : O(coins.length * amount)
// Space Complexity : O(coins.length * amount)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

//Approach

// We have a choice of including or not including the coins given to us to get the given amount
// We need to give the minimum of those choices
// We observe that there repeated overlapping sub problems
// so we use dp to solve this problem

class Solution {
    public int coinChange(int[] coins, int amount) {
        // bottom up approach
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[0][i] = amount + 1;
        }

        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j < coins[i - 1])
                    dp[i][j] = dp[i - 1][j];
                else {
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                }
            }
        }
        return dp[coins.length][amount] == amount + 1 ? -1 : dp[coins.length][amount];

    }

    // recursive code
    public int solve(int[] coins, int amount, int index, int count) {
        // base
        if (amount == 0)
            return count;
        if (index == coins.length || amount < 0) {
            return -1;
        }

        // logic
        // do not choose the coin // 0 case
        int case1 = solve(coins, amount, index + 1, count);

        // choose the coin // infinite coins
        int case2 = solve(coins, amount - coins[index], index, count + 1);

        // case1 where we donot choose the coin and the path didnt have answer
        if (case1 == -1)
            return case2;
        // case2 where we choose the coin and the path didnt have answer
        if (case2 == -1)
            return case1;
        return Math.min(case1, case2);

    }
}