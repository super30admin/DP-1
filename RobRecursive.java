// Time Complexity : o(2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Description: This is solved using recursive approach
class RobRecursive {
    public int rob(int[] nums) {
        return helper (nums,0,0);
    }
    
    
    public int helper (int[] nums, int i, int maxAmount) {
        
        if (i>= nums.length) return maxAmount;
        //case1: Choose house
        int case1 = helper(nums, i+2, maxAmount + nums[i]);
        
        //case2: Not choose house
        int case2 = helper(nums, i+1,maxAmount);
        
        return Math.max(case1,case2);
        
    }
}