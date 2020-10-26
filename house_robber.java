// Time Complexity : O(n), where n is the length of the nums array
// Space Complexity :O(1), as we are just using 3 constant variables
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : did not understand to do this problen with single dp array (and "not" dp[nums.length][2])


// Your code here along with comments explaining your approach
class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        //skip represents don't choose
        int skip = 0; 
        //take represents choose
        int take = nums[0];
        
        for(int i = 1; i<nums.length; i++){
            // save the skip in a temp variable
            int temp = skip;
            //skip will be the maximum of the previous skip and take
            skip = Math.max(skip , take);
            //take will be the previous skip plus the current number
            //we add previous skip because if we are taking the current house, then we cannot rob the previous adjacent house
            take = temp + nums[i];
        }
        
        //at last one of them will represent the highest robbing
        return Math.max(skip, take);
    }
}