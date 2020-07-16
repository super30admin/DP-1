// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*Used 2D array of size n*2
 * Consider House Not Chosen: Fill the 0 th column with values
 * Consider House Chosen:Fill the 1st column with the values considering the house is chosen
 * Result: Max of 2 columns from the last row of the 2D array*/

public class House_Robber_2D {
	public static int rob(int[] nums) {
	if(nums == null || nums.length == 0)
		return 0;
	
	int[][] dp = new int[nums.length][2];
	
	dp[0][0] = 0;
	dp[0][1] = nums[0];
	
	for(int i=1; i<nums.length; i++) {
		dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
		dp[i][1] = dp[i-1][0] + nums[i];
		
	}
	return Math.max(dp[nums.length-1][0], dp[nums.length-1][1]);
}
		
	public static void main(String[] args) {
		int[] nums = {1,2,3,1};
		System.out.print(rob(nums));

	}

}
