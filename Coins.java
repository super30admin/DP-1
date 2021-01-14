// Time Complexity : O(N^2)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : NO

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];		// create a new array with amount + 1 as the size
        dp[0] = 0;							// initialise the first place to 0
        for(int i = 1; i <= amount; i++){
            dp[i] = amount+1;
            for(int c : coins){
                if(i >= c){
                    dp[i] = Math.min(dp[i-c]+1, dp[i]);		// as we traverse through the amount and the coins array, we find the minimum number of coins required to achieve the target
                }
            }
        }
        return (dp[amount] == amount+1)? -1 : dp[amount];
    }
}