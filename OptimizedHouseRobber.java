class OptimizedHouseRobber {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        
        int skip = 0, take = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            int n = nums[i];
            int temp = skip;
            
            skip = Math.max(skip, take);
            take = temp + n;
        }
        
        return Math.max(skip, take);
    }
}