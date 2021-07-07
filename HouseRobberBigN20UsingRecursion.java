// Time complexity is o(2^n) or exponential
// Space complexity is O(1) as we are not using any extra space.
// Leetcode gives Time limit on submission

public class HouseRobberBigN20UsingRecursion {

	public int rob(int[] nums) {
		return helper(nums, 0, 0);
	}

	private int helper(int[] nums, int index, int stealing) {

		// base case
		if (index >= nums.length)
			return stealing;
		// logic
		// not choosing
		int case1 = helper(nums, index + 1, stealing);
		// choosing
		int case2 = helper(nums, index + 2, stealing + nums[index]);
		return Math.max(case1, case2);
	}

	public static void main(String[] args) {
		HouseRobberBigN20UsingRecursion house = new HouseRobberBigN20UsingRecursion();
		int [] nums = {1,2,3,1};
		house.rob(nums);
	}

}
