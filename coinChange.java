// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I had a hard time figuring out the bottom up approach and implementing it

import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int [] dp = new int [amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        
        for(int i = 1; i <= amount; i++)
        {
            for (int coin : coins)
            {
                if ((i - coin) >= 0)
                {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] <= amount ? dp[amount] : -1;
    }
}
    