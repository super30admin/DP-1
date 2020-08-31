
// Time Complexity : O(n)
// Space Complexity : O(n * amount)
// Did this code successfully run on Leetcode : Yes

import java.util.Arrays;

public class Problem_1 {
	 public int coinChange(int[] coins, int amount) {
	        
	        int[][] dp = new int[coins.length+1][amount+1];
	        Arrays.fill(dp[0], 99999);
	        for (int i = 1; i < dp.length; i++) {
	        	dp[i][0] = 0;
				for (int j = 1; j < dp[i].length; j++) {
					
					if(j < coins[i-1]) {
						dp[i][j] = dp[i-1][j];
					}else {
						dp[i][j] = Math.min(dp[i][j-coins[i-1]] + 1 , dp[i-1][j]);
					}
				}
			}
	        
			return dp[coins.length][amount] >= 99999 ? -1: dp[coins.length][amount];
	    
	    }
}
