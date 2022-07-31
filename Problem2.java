// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : No, encountered TLE
// Any problem you faced while coding this : Not with brute force, working on the optimized/dp solution


// Your code here along with comments explaining your approach
// Every element has two options, either to include or exclude it. 


class Solution {
    public int rob(int[] nums) {
        
        // TC: O(n)
        // SC: O(1)
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        
        int prev = nums[0];
        if(n == 1) return nums[0];
        int curr = Math.max(nums[0], nums[1]);
        for(int i = 2; i < n; i++) {
            int temp = curr;
            curr = Math.max(curr, nums[i] + prev);
            prev = temp;
        }
        return curr;
	}

}