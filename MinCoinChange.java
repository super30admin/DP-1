/* LC: 322 Easy https://leetcode.com/problems/coin-change/
// Time Complexity : O(amount * no_of_coins)
// Space Complexity : O(amount)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
Bottom-up approach
The min number of coins for amount x is min(1+ min_number_of_coins(x-i)), where i can take values <= x
*/

public class MinCoinChange {
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount + 1];
        
        for (int i = 0; i < dp.length; i++) {
            dp[i] = amount + 1;
        }
        
        dp[0] = 0;        
        
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                }
            }
        }
        
        return (dp[amount] == amount+1) ? -1: dp[amount];
    }
}