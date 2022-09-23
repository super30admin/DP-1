// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        int n = nums.length;
        int skip = 0;
        int pick = nums[0];
        int temp = 0;
        
        for(int i = 1 ; i < n ;i++)
        {
            temp = skip;
            skip = Math.max(skip,pick);
            pick = temp + nums[i];
        }
        
        return Math.max(skip,pick);
    }
}