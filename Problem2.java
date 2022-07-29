// Time Complexity : O(2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : No, encountered TLE
// Any problem you faced while coding this : Not with brute force, working on the optimized/dp solution


// Your code here along with comments explaining your approach
// Every element has two options, either to include or exclude it. Call helper method recursively till array is exhausted and keep returning max out of including option and excluding option


class Solution {
    public int rob(int[] nums) {
        return helper(nums, 0);
	}

	private int helper(int[] nums, int i) {
		if (i >= nums.length) {
			return 0;
		}
		return Math.max(helper(nums, i + 2) + nums[i], helper(nums, i + 1));
    }
}