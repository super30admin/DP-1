// Time Complexity : O(n) n= houses
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * We will be using the dp approach. We use the bottom up approach.
 */
class Solution {
    public int rob(int[] nums) {
        //edge
        if (nums == null || nums.length == 0) return 0;

        //using array to keep track of previous total amount
        int skip = 0, take = nums[0];
        Arrays.stre
        for (int i = 1; i < nums.length; i++) {
            int temp = skip;
            //skip/ don't choose
            skip = Math.max(skip, take);
            //we choose
            take = temp + nums[i];
        }
        return Math.max(skip, take);
    }
}