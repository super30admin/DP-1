// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

class Solution {
	public int rob(int[] nums) {
		// Recursive approach without storing previous states
//        if (nums == null || nums.length == 0) return 0;
//        return helper(nums, 0, 0);
//    }
//    
//    private int helper(int[] nums, int i, int amount) {
//        // base
//        if (i >= nums.length) return amount;
//        
//        // logic
//        // case 1, choose
//        int case1 = helper(nums, i+2, amount + nums[i]);
//        
//        // case 2, not choose
//        int case2 = helper(nums, i+1, amount);
//        
//        return Math.max(case1, case2);

		// Dynamic Programming approach
		if (nums == null || nums.length == 0)
			return 0;

		int n = nums.length;
		if (n == 1)
			return nums[0];

		// int[] dp = new int[n];
		// dp[0] = nums[0];
		// dp[1] = Math.max(nums[0], nums[1]);
		// Space can be optimized to eliminate the use of array by taking 2 variables
		// which store previous 2 states to get the current state
		int prev = nums[0];
		int curr = Math.max(nums[0], nums[1]);

		for (int i = 2; i < n; i++) {
			int temp = curr;
			// dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
			curr = Math.max(curr, nums[i] + prev);
			prev = temp;
		}

		// return dp[n - 1];
		return curr;
	}
}