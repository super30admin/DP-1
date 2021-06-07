// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int rob(int[] nums) {
        int take = 0;
        int skip = 0;
        for(int i = 0; i < nums.length;i++){
            //store previous skip before modification
            int tempSkip = skip;
            //maximum robbing when skipping the house case 0
            skip = Math.max(skip,take);
            //maximum robbing on considering the house case 1
            take = nums[i] + tempSkip;
        }
        return Math.max(skip,take);
    }
}