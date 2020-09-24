// Time Complexity : O(N) - N is the size of the array
// Space Complexity : O(N) - we used a dp array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0 || coins.length == 0) return 0;
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for(int amt = 1;amt <= amount;amt++){
            dp[amt] = amount + 1;
            for(int coin : coins){
                if(coin <= amt){
                    dp[amt] = Math.min(1 + dp[amt - coin],dp[amt]);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
// Your code here along with comments explaining your approach
