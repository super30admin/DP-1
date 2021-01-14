class Solution3 {
	
	//	Time:  Exponential
	//	Space O(1) ignoring the recursive stack
	//	LeetCode: time limit exceeded
	public int rob(int[] nums) {

		return helper(nums, 0,0);
	}

	private int helper(int[] nums, int i , int max) {
		//base case
		if(i >= nums.length) return max;
		//case1 rob
		int case1 = helper(nums, i+2, max + nums[i]);

		//case2  dont rob
		int case2 = helper(nums, i+1, max);

		int result = Math.max(case1,case2);
		return result;
	}
}