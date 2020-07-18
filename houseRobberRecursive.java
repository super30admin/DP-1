// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Time Limit Exceeded
class Solution {
    public int rob(int[] nums) {
        return helper(nums, 0, 0);
    }
    private int helper(int[] nums, int index, int amount){
        if(index>=nums.length) return amount;
        int case1 = helper(nums, index+1, amount); //house is not robbed
        int case2 = helper(nums, index+2, nums[index] + amount); //house is robbed
        return Math.max(case1,case2);
    }
}