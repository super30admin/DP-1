// Time Complexity : O(amount * n)
// Space Complexity : O(amount)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I had to look for syntax in the return statement because I wanted to check and return at the same time


// Your code here along with comments explaining your approach

## Problem1 (https://leetcode.com/problems/coin-change/)


class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];                 //integer array dp of size amount + 1
        Arrays.fill(dp, Integer.MAX_VALUE);             //sets all elements of the dp array to Integer.MAX_VALUE
        dp[0] = 0;                                      //  all elements of dp are set to infinity except dp[0] which is set to 0

        for (int coin : coins) {                                    // iterates through each coin in the coins array
            for (int i = coin; i <= amount; i++) {                  // iterates through each possible amount i that can be made up using the current coin denomination
                if (dp[i - coin] != Integer.MAX_VALUE) {            // checks whether we can make up the amount i using the current coin denomination
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);      //If we can make up the amount i - coin using the previous coins, then we can use the current coin to make up the amount i by adding 1 to the minimum number of coins
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];   //check whether dp[amount] is equal to Integer.MAX_VALUE and returns the minimum number of coins needed to make up the amount 'amount' or '-1'
    }
}
