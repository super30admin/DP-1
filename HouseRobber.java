// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        return solve(nums, 0, 0);
    }
    public int solve(int[] nums, int i, int amount) {
        if (i >= nums.length)
            return amount;
        int case1 = solve(nums, i + 1, amount);
        int case2 = solve(nums, i + 2, amount + nums[i]);
        return Math.max(case1, case2);
    }
}
