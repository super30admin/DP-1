class RobRecursive {
    public int rob(int[] nums) {
        return helper (nums,0,0);
    }
    
    
    public int helper (int[] nums, int i, int maxAmount) {
        
        if (i>= nums.length) return maxAmount;
        //case1: Choose house
        int case1 = helper(nums, i+2, maxAmount + nums[i]);
        
        //case2: Not choose house
        int case2 = helper(nums, i+1,maxAmount);
        
        return Math.max(case1,case2);
        
    }
}