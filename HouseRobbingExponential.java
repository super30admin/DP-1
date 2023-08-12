class Solution {
    public int rob(int[] nums) {
        return helper(nums, 0, 0);
        
    }

    public int helper(int[] nums, int amount, int i){

        //base
        if(i >= nums.length ) return amount;

        //logic
         //nochoose
        int case0 = helper(nums, amount, i+1);
        //choose
        int case1 = helper(nums, amount+nums[i] , i+2);
       
         return Math.max(case0, case1);
    }
}