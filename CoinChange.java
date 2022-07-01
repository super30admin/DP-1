// Time Complexity : O(M+N)
// Space Complexity :O(M)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp [] = new int [amount+1] ;
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0 ;
        for(int i = 0 ; i <= amount ; i++)
            for(int j : coins)
                dp[i] = (j <= i && dp[i - j] != Integer.MAX_VALUE) ? Math.min(dp[i-j]+1, dp[i]) : dp[i];  
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}






