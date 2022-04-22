// Time Complexity: O(n) where n is the lengthb of the array.
// Space complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class HouseRobber {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int skip = 0;
        int take = nums[0];
        for(int i = 1; i < n; i++) {
            int temp = skip;
            skip = Math.max(skip, take);
            take = nums[i] + temp;
        }
        return Math.max(skip, take);
    }
}
    // // Time Complexity: O(n) where n is the length of array.
    // // Space Complexity: O(n) where n is the length of array.
    // public int rob(int[] nums) {
    //     if(nums == null || nums.length == 0) return 0;
    //     int n = nums.length;
    //     int[][] dp = new int[n][2];      // S.C.: O(n).
    //     dp[0][1] = nums[0];      // dp[0][0] = 0 by default.
    //     for(int i = 1; i < n; i++) {
    //         dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);     // Didn't rob current house.
    //         dp[i][1] = dp[i - 1][0] + nums[i];   // Robbed the house.
    //     }
    //     return Math.max(dp[n - 1][0], dp[n - 1][1]);
    // }

    
// Exhaustive approach.   
// Time complexity: O(2 ^ n) where n is the length of the array.    
// Space Complexity: O(h) where h is the height of the dp tree.
//     public int rob(int[] nums) {
//         if(nums == null || nums.length == 0) return 0;
//         return helper(nums, 0, 0);
//     }
    
//     private int helper(int[] nums, int index, int amount) {
//         // base
//         if(index >= nums.length) return amount;
        
//         // logic
//         // Case1: Did not rob the house.
//         int case1 = helper(nums, index + 1, amount); 
//         // Case2: Robbed the house.
//         int case2 = helper(nums, index + 2, amount + nums[index]);
//         return Math.max(case1, case2);
//     }