class Solution {
    public int helper(int[] nums, int ind, int amt) {
        if(ind >= nums.length) {
            return amt;
        }
        int case1 = helper(nums, ind + 2, amt + nums[ind]);
        int case2 = helper(nums, ind + 1, amt);
        return Math.max(case1, case2);
    }
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        return helper(nums, 0, 0);
    }
}