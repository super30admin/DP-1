// Time Complexity : n
// Space Complexity : n
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

class HouseRobber{
    public int rob(int[] nums){

        if(nums == null || nums.length == 0) return 0;
        int[][] dp = new int[nums.length][2];

        dp[0][1] = nums[0];
        for(int i=1; i<nums.length; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = dp[i-1][0] + nums[i];
        }

        return Math.max(dp[nums.length-1][0], dp[nums.length-1][1]);
    }
    // public int rob(int[] nums) {
    //     return helper(nums, 0, 0);
    // }

    // private int helper(int nums[], int index, int amount){
    //     // base
    //     if(index >= nums.length) return amount;
    //     // house robbed case
    //     int case1 = helper(nums, index+2, amount + nums[index]);
    //     // house not robbed
    //     int case2 = helper(nums, index+1, amount);
    //     return Math.max(case1, case2);
    // }
}