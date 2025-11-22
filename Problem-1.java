// Time Complexity :O(m*n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
//I created a DP array where each index represents the minimum coins needed to form that amount.
// For every amount, I loop through all coins and update the value by checking the best possible previous state.
// In the end, if the value is still MAX_VALUE, it means the amount can't be formed, otherwise I return the computed minimum.

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        if (amount<0){
            return -1;
        }
        for (int i = 1; i < amount+1; i++){
            for (int j =0; j < coins.length; j++){
                if ( i >= coins[j] && dp[i - coins[j]] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i], 1+dp[i-coins[j]]);
                }
            }
        }
        if (dp[amount] == Integer.MAX_VALUE){
            return -1;
        }else{
            return dp[amount];
        }
        
        
    }
}