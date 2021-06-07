// Time Complexity : O(2 pow n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int rob(int[] nums) {
        return helper(nums,0,0);
    }
    
    private int helper(int[] nums, int index, int robbings){
        //base case
        if(index >= nums.length)
            return robbings;
        //choose the house
        int case1 = helper(nums,index + 2,robbings + nums[index]);
        //do not choose the house
        int case2 = helper(nums,index + 1,robbings);
        
        return Math.max(case1,case2);
    }
}