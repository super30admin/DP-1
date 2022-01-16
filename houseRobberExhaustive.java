//Time complexity: O(2^n)
//Space complexity: O(1)
//Exhaustive approach

class Solution {
    public int rob(int[] nums) {
        
        if(nums== null) return 0;
        return helper(nums, 0,0); 
    }
    
    private int helper(int[] nums, int index, int amount){
        //base
        if(index >= nums.length) return amount;
        //logic
        //choose
        int case1 = helper(nums, index + 2, amount + nums[index]);
        //not choose
        int case2 = helper(nums, index + 1, amount);
        return Math.max(case1, case2);
    
    }
}