class Solution {
    public int rob(int[] nums) {
        // If nums array length is less than or equal to 1, check if nums length is 0, if yes return 0 else nums[0]
        if(nums.length <= 1){
            return nums.length == 0 ? 0 : nums[0];
        }
        // Initializing a dp array with length of nums array size
        int[] dp = new int[nums.length];
        // We store the value nums[0] at ith index of dp and max of nums[0] and nums[1] at 1st index of dp array
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        // Iterate through nums array from 2 -> nums.length - 1
        for(int i=2; i<nums.length; i++){
            // compare values of sum of current index of nums value, 2 indexes back in dp array and i-1 index of dp. Store the max value at ith index in dp array. We know, the previous numbers in the dp array are max cumulative sums.
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }
        // return dp.length - 1 index in dp array
        return dp[dp.length - 1];
    }
}