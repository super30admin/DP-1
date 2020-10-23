package Oct22;


class HouseRobber {
    public int rob(int[] nums) {
        
    // Time Complexity: O(n) where n is no.of elements in the nums array.
    // We need to iterate through the nums array once to populate the dp array.

	// Space Complexity: O(n) where n is no.of elements in the nums array.
    // Because we are using additional array space of n+1 elements which asymptotically boils down to O(n)
	        
	// Did this code successfully run on Leetcode : Yes

	// Any problem you faced while coding this : No

	// Approach: 
	// Recursive approach fails with large inputs since m*(2^n) complexity.
	// So going for DP,since recursive tree shows that there are repeated sub-problems.
        
        // Edge cases
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        return helper(nums, 0);
    }
    
// DP function 
    public int helper(int[] nums, int index) {
        
// single dim dp array of 1 size greater than nums array.
        int[] dp = new int[nums.length+1];
        
// initializing the dp array when no houses available or only one house available in nums array
        dp[0] = 0;
        dp[1] = nums[0];
        
        for (int i = 2; i < dp.length; i++) {
// loot the house at index (i-1), since i-1 index in nums array corresponds to i index in dp array
            int case1 = nums[i-1] + dp[i-2];
// Don't loot the house at index (i-1), since i-1 index in nums array corresponds to i index in dp array
            int case2 = dp[i-1];
            dp[i] = Math.max(case1, case2);
        }
        
        return dp[dp.length-1];    
    }
}
