// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int skip = 0;
        int take = nums[0];
        
        for(int i = 1; i < nums.length; i++){
            int temp = skip;
            //not choose
            skip = Math.max(skip, take);
            //choose
            take = temp + nums[i];
        }
        return Math.max(take,skip);
    }
}
