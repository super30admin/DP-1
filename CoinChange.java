package Oct21;

class CoinChange {

	// Time Complexity: O(mn) where m is no.of elements in the coins array and n is target amount. 
	// Because we are traversing the dp 2-d array once completely across all m rows and n columns.

	// Space Complexity: O(mn) where m is no.of elements in the coins array and n is target amount. 
	// Because we are forming dp grid of (m+1)*(n+1) elements.
	        
	// Did this code successfully run on Leetcode : Yes

	// Any problem you faced while coding this : No

	// Approach: 
	// Recursive approach fails with large inputs since m*(2^n) complexity.
	// So going for DP,since recursive tree shows that there are repeated sub-problems.
	    
	    public int coinChange(int[] coins, int amount) {
	        
	        if (coins == null || coins.length == 0) {
	            return -1;
	        }
	        
	        return helper(coins, amount);
	    }
	    
	    public int helper(int[] coins, int amount) {
	        
	        int rows = coins.length + 1;
	        int cols = amount + 1;
	        int[][] dp = new int[rows][cols];
	        
	        // 1st column of the array should be set to 0 which is default value of array elements in java. Need not do anything for this explicitly.
	        // 1st row of the array should be set to Integer.MAX for all columns except column 0.
	        // Initializing in the array below
	        for (int i = 1; i < cols; i++) {
	            dp[0][i] = 9999;
	        }
	        
	        // populating the dp matrix
	        for (int i = 1; i < rows; i++) {
	            for (int j = 1; j < cols; j++) {
	                if (j < coins[i-1]) {
	                    dp[i][j] = dp[i-1][j];
	                } else {
	                dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j-coins[i-1]]);
	                }
	            }
	        }
	        
	        // if last element at the right bottom corner of the grid is 9999, it implies there is no solution, so return -1 
	        // else return the value stored at last element at the right bottom corner of the grid
	        if (dp[rows-1][cols-1] == 9999) {
	            return -1;
	        }
	        return dp[rows-1][cols-1];      
	    }
	}