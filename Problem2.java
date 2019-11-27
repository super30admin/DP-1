//Brute force
// Time Complexity
//Space Complexity
// This code did not work on LeetCode and ended in Time Exceeded error.

class Solution {
    public int rob(int[] nums) {
        return helper(nums,0,0);
    }
    private int helper(int[] nums,int i,int amount){
        // Base Case
        if(i >=nums.length) return amount;
        // Logic
        //chosen
        int Case1 = helper(nums,i+2,amount+nums[i]);
        //not chosen
        int Case2 = helper(nums,i+1,amount);
        return Math.max(Case1,Case2);
    }
}
