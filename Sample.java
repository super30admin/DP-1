// Time Complexity : O(n^2) where n is the number of decisions made at each level
// Space Complexity : O(m*n), for making use of dp[][] matrix to store the optimal sub-structures and eventually the final result.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I was able solve the problem on paper, while writing the code I initially found it difficult to come up with the conditions. With few errors & with the help of video lecture, I was able to figure out the way.


// Your code here along with comments explaining your approach

/*
 * Coin change problem is basically trying to find out the least number of ways to reach the final target. Initially I started with the approach of selecting each coin and seeing if I reached the target, again making a decision not to select and repeat the procedure of Choose/not choose at every level.
 * Came across scenarios where the overlapping subproblems were present, and optimal substructure at each interval helped in finding the result.
 * Made use of a 2D matrix to store the results at each index.
 * Every element represents the minimum number of ways to reach the amount.
 * Main conditions that were kept in mind was: 
 * 1. when the given coin denomination is greater than the amount. (copy the value on the previous row, same column)
 * 2. find the minimum of making a choice to 1. keep the coin, 2. not keep the coin. 
 * */

class Solution{
	
	public static int coinChange(int[] coins,int amount) {
		
		//define row
		int row = coins.length+1;
		
		//define column
		int col = amount+1;
		
		int[][] dp = new int[row][col];
		
		//The first row, all the columns from 1 are made infinite as we keep adding '0' and we wont be able to reach the total number of coins.
		for(int j=1;j<col;j++)
			dp[0][j] = 10001;
		
		//1.Choose -> choosing one denomination 1+current amount - denomination at that index 2.Don't choose -> option when we dont select the coin denomination. We just use the value which is in the above row.
		for(int i=1;i<row;i++) {
			for(int j=1;j<col;j++) {
				if(coins[i-1]>j)
					dp[i][j] = dp[i-1][j];
				else {
					dp[i][j] = Math.min(1+dp[i][j-coins[i-1]], dp[i-1][j]);
				}
			}
		}
		
		return dp[row-1][col-1] == 10001 ? -1:dp[row-1][col-1];
		
	}
	
	
	// Time Complexity : O(n)
	// Space Complexity : O(1)
	// Did this code successfully run on Leetcode : yes
	// Any problem you faced while coding this : no
	
	/*
	 * Adjacent houses wont be robbed, So at every house I had an option either to choose the house or not. If the house is Chosen, I can consider the path sum of previously not chosen value. Similarly, If I am not choosing a house I can select the Max of previously chosen or not chosen house.
	 * */
	public static int houseRobber(int[] nums) {
		if(nums==null || nums.length ==0)
			return 0;
		
		int C = 0, DC = 0;
		
		for(int x:nums) {
			int temp = DC;
			DC = Math.max(C, DC);
			C = x + temp;
		}
		
		return Math.max(C, DC);
	}
}
