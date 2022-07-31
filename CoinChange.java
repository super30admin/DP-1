// Time Complexity : O(mn), where m = number of denominations, n = change remaining at every possible state
// Space Complexity : O(mn), where m = number of denominations, n = change remaining at every possible state
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

class Solution {
	public int coinChange(int[] coins, int amount) {
		// Recursive approach without storing previous states
//        if (coins == null || coins.length == 0) return 0;
//        return helper(coins, amount, 0, 0);
//    }
//    
//    private int helper(int[] coins, int amount, int i, int numberOfCoins) {
//        // base case
//        if (amount == 0) return numberOfCoins;
//        
//        if (i == coins.length || amount < 0) return -1;
//        
//        // logic
//        // case 1, choose
//        int case1 = helper(coins, amount - coins[i], i, numberOfCoins + 1);
		
		  // case 2, not choose
//        int case2 = helper(coins, amount, i+1, numberOfCoins);
//        
//        if (case1 == -1) return case2;
//        if (case2 == -1) return case1;
//        
//        return Math.min(case1, case2);

		// Dynamic Programming (Bottom-Up Approach)
		if (coins == null || coins.length == 0)
			return 0;

		int m = coins.length, n = amount;
		int[][] dp = new int[m + 1][n + 1];
		dp[0][0] = 0;

		// top row
		for (int j = 1; j < dp[0].length; j++) {
			dp[0][j] = amount + 1;
		}

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				// till amount is not equal to denomination
				if (j < coins[i - 1]) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
				}
			}
		}

		int numberOfCoins = dp[m][n];

		if (numberOfCoins > amount)
			return -1;

		return numberOfCoins;
	}
}