// Recursive TLE O(2^n) time, O(n) space
// class Solution {
//     public int rob(int[] nums) {
//         return helper(0, nums);
//     }

//     public int helper(int i, int[] nums) {
//         if (i == nums.length) return 0;

//         int rob = nums[i] + helper(i+2, nums);
        
//         int dontRob = helper(i+1, nums);

//         return Math.max(rob, dontRob);
//     }
// }


// Bottom up DP O(n) time, O(n) space
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];

        dp[0] = 0;
        dp[1] = nums[0];

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i-1], nums[i-1] + dp[i-2]);
        }
        return dp[n];
    }
}
