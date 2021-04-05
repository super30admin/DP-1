// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :

class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0 || nums == null)
            return 0;
        int skip = 0;
        // if only one house rob that house
        int take = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int temp = skip;
            // if house is skipped take the maximum of previous skip and taken
            skip = Math.max(skip, take);
            // if taken add the skip value of previous one to the current house value
            take = temp + nums[i];
        }
        return Math.max(skip, take);
    }
}