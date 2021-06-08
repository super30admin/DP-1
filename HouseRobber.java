// Time Complexity : O(N) //N is number of houses
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/**
 * 1. Form a DP table with column header as not chosen 0 and chosen 1
 * 2. First house fill with the nums array values
 * 3. at each house not chosen than max(last house  of chosen,not chosen) .
 * 4. at each house chosen ten last house not chosen+current house value.
 * 5. end return max of chosen or not chosen
 */

public class HouseRobber {

	public int rob(int[] nums) {

		int noOfHouses = nums.length;
		int[][] dp = new int[noOfHouses][2];

		dp[0][1]=nums[0];

		for (int i = 1; i < noOfHouses; i++) {
			
			//not chose
			dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][0]);
			//chose
			dp[i][1]=dp[i - 1][0]+nums[i];
		}

		return Math.max(dp[noOfHouses - 1][1],dp[noOfHouses - 1][0]);

	}

	public static void main(String[] args) {

		System.out.println(new HouseRobber().rob(new int[] {1,2,3,1}));
	}
}
