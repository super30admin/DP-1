// Time Complexity: O(n * m), where n is the number of coins and m is the target amount.
// Space Complexity: O(m), as a 1D DP array of size m + 1 is used.

// Approach: Create a DP array where dp[i] represents the minimum number of coins needed to make amount i, initialize dp[0] to 0 and all other values to amount + 1 as they are initially unreachable.
// For each amount, iterate through all the coins, and if a coin is less than or equal to the current amount, update dp[i] by taking the minimum of not picking the coin (dp[i]) and picking the coin (1 + dp[i - coin]).
// Return dp[amount] if the target amount can be formed; otherwise, return -1.

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Initially used Integer.MAX_VALUE, which caused integer overflow.

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for(int i=1;i<amount+1;i++){
            dp[i] = amount+1;
        }
        for(int i=1;i<dp.length;i++){
            for(int coin : coins){
                if(coin <= i){
                    dp[i]= Math.min(dp[i],1+dp[i-coin]);
                }
            }
        }
        if(dp[amount] == amount+1){
            return -1;
        }
        
        return dp[amount];
    }
}
