// Problem 1: 

// Time Complexity : O(n^2) -
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Has difficulties understanding the sub problems of the binary tree.


// Your code here along with comments explaining your approach
class Solution {
	public int coinChange(int[] coins, int amount) {
		if(coins == null || coins.length == 0) return 0;
		int [][] dp = new int[coins.length + 1][amount + 1];
		int m = dp.length; int n = dp[0].length;
		for(int j = 1; j < n; j++) {
			dp[0][j] = 9999;
		}
		for(int i = 1; i < m; i++) {
			for(int j = 1; j < n; j++) {
				if(j < coins[i-1]) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
				}
			}
		}
		int result = dp[m - 1][n - 1];
		if(result >= 9999) return -1;
		return dp[m - 1][n - 1];
	}
}