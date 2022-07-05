// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int skip = 0; // 0 column, 1st row
        int take = nums[0]; // 1 column, 1st row
        int n = nums.length;

        for (int i = 1; i < n; i++) {
            // 0 case
            int temp_skip = skip; // to preserve the previous value of skip to calculate take.
            skip = Math.max(skip, take);

            // 1 case
            take = temp_skip + nums[i];
        }

        return Math.max(skip, take); // the max value among the last skip and take is the output

    }
}