// Time Complexity : Exponential
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Bottom up approach

class Solution {
    public int rob(int[] nums) {
        return helper(nums, 0,0);
    }
    
    private int helper(int[] nums, int idx, int sum){
        //Base
        if(idx >= nums.length) return sum;
        
        //Logic
        int case1 = helper(nums, idx+1, sum);
        int case2 = helper(nums, idx+2, sum+nums[idx]);
        return Math.max(case1,case2);
    }
}