// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0; //base case
        if (coins == null || coins.length == 0) return -1; //base case
        
        int[] dp = new int[amount + 1]; 
        dp[0] = Integer.MAX_VALUE;
        
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] > amount) continue;
            dp[coins[i]] = 1; //initialize the array
        }
        
        for (int i = 1; i < amount + 1; i++) {
            if (dp[i] == 1) continue;
            int minCoinsNeeded = Integer.MAX_VALUE;
            
            for (int j = 0; j < coins.length; j++) {
                int amountleft = i - coins[j];
                if (amountleft < 0) continue;
                minCoinsNeeded = Math.min(dp[amountleft], minCoinsNeeded);
            }
            
            dp[i] = minCoinsNeeded == Integer.MAX_VALUE ? Integer.MAX_VALUE : minCoinsNeeded + 1;
        }
        
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
