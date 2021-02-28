// Time Complexity : O(n. m), n = length of coins array, m = amount.
// Space Complexity : O(m), m = amount.
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

class Solution {
    
    // dp[amount - coins[k]] + 1 will get the answer
    // We check it with prev value because the coins array need not be sorted
    
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, 10001);
        dp[0] = 0;
        for(int k = 0; k < coins.length; k++){
            for(int i = 1; i < dp.length; i++){
                if(i >= coins[k])
                    dp[i] = Math.min(dp[i], dp[i-coins[k]] + 1);
            }
        }
        return (dp[amount] > 10000) ? -1 : dp[amount];
    }
}
