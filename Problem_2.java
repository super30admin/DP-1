// Time Complexity : O(n), n = length of array nums. 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int C = nums[0];
        int DC = 0, temp = 0;
        
        for(int i = 1; i < nums.length; i++){
            temp = C;
            C = nums[i] + DC;
            DC = Math.max(DC, temp);
        }
        return Math.max(C, DC);
    }
}
