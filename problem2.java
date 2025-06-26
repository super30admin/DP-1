// Time Complexity : O(n) where n is nums length
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach - Using two variables to store values of maximum money we can get from either previous1 exact neighbor or previous 2 (i-2) house.
// Now I have two choices, I can include this house or exclude it, including, I add the money from this house and alternate before, else the previous one. 

class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        if(nums.length==2) return nums[0]>nums[1]?nums[0]:nums[1];
        int prev2 = nums[0];
        int prev1 = Math.max(nums[0], nums[1]);
        for(int i = 2; i<nums.length;i++){
            int include = prev2 + nums[i];
            int exclude = prev1;
            prev2 = prev1;
            prev1 = Math.max(include,exclude);
        }
        return prev1;
    }
}