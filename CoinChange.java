// Time Complexity :O(m*n) where m is the number of coins and n is the amount to reach
// Space Complexity :O(n) where n is the amount to reach
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

// Consider a 2d dp array where each dp[i][j] gives the minimum number of coins required to reach j using coins upto i index
// so dp [i][j] should be minimum of choose and not choose possibility.
// Dont choose means whatever was the previous value will be continued
// choose means we add 1 (chosen coin denomination) to dp[i-coin value](which means target-selected coin's value )
class Solution {
    public int coinChange(int[] coins, int amount) {

        int dp[] = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        Arrays.sort(coins);
        dp[0] = 0;

        for (int coin : coins) {
            for (int i = 1; i < amount + 1; i++) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}