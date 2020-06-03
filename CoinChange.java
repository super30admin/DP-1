// Time Complexity : O(S*N)
// Space Complexity : O(S) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Watched a video related to it on Youtube as I wasn't able to come up with solution
// Then coded it on my own based on explanation


// Your code here along with comments explaining your approach
import java.util.Arrays;
class Solution {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount+1];
        Arrays.fill(dp,max);
        dp[0] = 0;
        // DP bottom - up approach
        for(int i = 1; i <= amount; i++) {
            for(int j = 0; j < coins.length; j++) {
                if(coins[j] <= i) { 
                    dp[i] = Math.min(dp[i], dp[i-coins[j]]+1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}