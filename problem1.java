//time complexity-O(mxn){m-amount,n=no of coins}
//space complexity-O(mxn)
//passed all the test cases on leetcode
//the approach is here to find all the ways by using take and not take using recursion the memoize it and then tabulate it.
class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[][] = new int[amount + 1][n];
        for (int i = 0; i <= amount; i++) {
            if (i % coins[0] == 0)
                dp[i][0] = i / coins[0];
            else
                dp[i][0] = (int) Math.pow(10, 8);
        }
        for (int i = 0; i <= amount; i++) {
            for (int j = 1; j < n; j++) {
                int not = dp[i][j - 1];
                int take = (int) Math.pow(10, 8);
                if (coins[j] <= i) {
                    take = 1 + dp[i - coins[j]][j];
                }
                dp[i][j] = Math.min(take, not);
            }
        }
        if (dp[amount][n - 1] >= (int) Math.pow(10, 8))
            return -1;
        return dp[amount][n - 1];
    }
}