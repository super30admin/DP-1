// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i=0;i<dp.length;i++) {
                for(int j=0; j<coins.length; j++) {
                    int newIndex = i + coins[j];
                    if(coins[j] >= Integer.MAX_VALUE)
                        continue;
                    if(newIndex <= amount && dp[i]<Integer.MAX_VALUE) {
                        dp[newIndex] = Math.min(dp[newIndex], 1+dp[i]);
                    }
                }
        }
        if (dp[amount] == Integer.MAX_VALUE)
	        return -1;
	    return dp[amount];
    }
}
