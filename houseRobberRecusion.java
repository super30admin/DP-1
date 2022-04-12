/**
Problem: https://leetcode.com/problems/house-robber/
TC: O(2^n)
SC: O(n) for call stack
*/
class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return helper(nums, 0, 0);
    }
    
    private int helper(int[] nums, int index, int amount) {
        //base
        if (index >= nums.length) {
            return amount;
        }
        // logic
        int case1 = helper(nums, index + 2, amount + nums[index]);
        int case2 = helper(nums, index + 1, amount);
        return Math.max(case1, case2);
        
    }
}