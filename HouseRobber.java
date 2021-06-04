// Time Complexity : O(N) //N is number of houses
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/**
 * 1. Form a DP table as no target one dimensional will work
 * 2. First 2 houses values is calculated outside loop
 * 3. at each house check max(n-1,n-2+n) value.
 */

public class HouseRobber {

	public int rob(int[] nums) {

		int noOfHouses = nums.length;
		int[] dp = new int[noOfHouses];

		//only one house thats the solution
		if (noOfHouses >= 1) {
			dp[0] = nums[0];
		}

		//only 2 houses so max of it is the solution
		if (noOfHouses >= 2) {
			dp[1] = Math.max(nums[0], nums[1]);
		}

		//check current and previous alternate with previous one for max value
		for (int i = 2; i < noOfHouses; i++) {
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
		}

		return dp[noOfHouses - 1];

	}

	public static void main(String[] args) {

		System.out.println(new HouseRobber().rob(new int[] {1,2,3,1}));
	}
}
