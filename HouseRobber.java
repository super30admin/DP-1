class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int skip = 0, take = nums[0];
        for(int i =1; i < nums.length; i++) {
            int temp = Math.max(skip, take);
            take = skip + nums[i];
            skip = temp;
        }
        return Math.max(skip, take);
        // return helper(nums, 0, 0);
    }
    
    // private int helper(int[] nums, int index, int max) {
    //     //base
    //     if(index >= nums.length)
    //         return max;
    //     //logic
    //     int case1 = helper(nums, index + 1, max);
    //     int case2 = helper(nums, index + 2, max + nums[index]);
    // return Math.max(case1, case2);
    // }
}