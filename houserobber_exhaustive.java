//Exhaustive
//TC: Exponential
class Solution {
    public int rob(int[] nums) {
        if(nums == null) return 0;
        return helper(nums, 0, 0);
    }
    
    private int helper(int[] nums, int i, int amount){
        //base
        if(i >= nums.length) return amount;
        
        //logic
        //choose
        int case1 = helper(nums, i+2, amount + nums[i]);
        //not choose
        int case0 = helper(nums, i+1, amount);
        
        int result = Math.max(case1,case0);
        return result;
    }
    
}
