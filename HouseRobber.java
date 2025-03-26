
// Gives a time limit exceeded exception
// class HouseRobber {
//     public int rob(int[] nums) {
//         return helper(nums, 0, 0);
//     }

//     private int helper(int[] nums, int i, int robbings) {
//         // base case
//         // We have to do >= and not == because we are doing i+1 and i+2. so, if our pointer it aftrer 4] <here> <here> it will not capture that scenario, i==6
//         // will be checked but it might be actually 7
//         if(i >=nums.length) return robbings;

//         //logic
//         int case0= helper(nums, i+1, robbings);
//         int case1 = helper(nums, i+2, robbings+nums[i]);

//         return Math.max(case0, case1);
//     }
// }

// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


class HouseRobber {
    public int rob(int[] nums) {
        int n = nums.length;
        int[]dp = new int[n];

        if (n == 1) return nums[0]; // Handle single-element array
        if (n == 0) return 0;       // Handle empty array

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i=2; i<n; i++) {
            dp[i] = Math.max(dp[i-1], nums[i]+dp[i-2]);
        }

        return dp[n-1];
    }
}