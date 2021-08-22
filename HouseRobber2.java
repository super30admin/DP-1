// Time Complexity : O(n) , n = length of nums array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        
        if(nums.length == 1)
            return nums[0];
        
        int choose = nums[0], skip = 0;
        for(int i=1; i<nums.length; i++) {
            int prevSkip = skip;
            skip = Math.max(choose, skip);
            choose = nums[i] + prevSkip;
        }
        return Math.max(choose,skip);
    }
}