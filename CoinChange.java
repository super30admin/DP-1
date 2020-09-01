// Time Complexity :O(m*n) where m is the number of coins and n is the amount to reach
// Space Complexity :O(n) where n is the amount to reach
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

// this is a 2d array in which 1d array is computed (number of coin denomination) times

// Consider a 2d dp array where each dp[i][j] gives the minimum number of coins required to reach j using coins upto i index
// so dp [i][j] should be minimum of choose and not choose possibility.
// Dont choose means whatever was the previous value will be continued
// choose means we add 1 (chosen coin denomination) to dp[i-coin value](which means target-selected coin's value )
class Solution {
    public int coinChange(int[] coins, int amount) {
        // here first element is = 0 because we have no coins and we have to reach 0
        // and the rest of the elements are set as infinty or amt+1
        // X | 0 1 2 3 4 5 6 7
        // 0 | 0 8 8 8 8 8 8 8 --> first row
        // 1 | 0 1 2 3 4 5 6 7
        // 2 | 0 1 1 2 2 3 3 4
        // 5 | 0 1 1 2 2 2 2 2
        int dp[] = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        Arrays.sort(coins);
        dp[0] = 0;

        for (int coin : coins) {
            for (int i = 1; i < amount + 1; i++) {
                // we only go inside this block if the coin is useful i.e (bigger than the
                // current target if not then skip this because it is useless)
                if (i >= coin) {
                    // we see the min of previous dp[i] (continuing the previous which means not
                    // chosen) and (if chosen) then 1+dp[i-coin] which means we add that 1 coin to
                    // the number of coins required to get to complement (i.e target-coins value)
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}