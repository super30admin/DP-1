// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach
// Maintain pointers for the previous 2 indices instead of the dp array
class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        if (nums.length == 1)
            return nums[0];

        int rs = nums[0];
        int prev1 = nums[0];
        int prev2 = 0;

        for (int i = 1; i < nums.length; i++) {
            rs = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = rs;
        }
        return rs;
    }
}

// DP array - Takes up O(n) space
// class Solution {
// public int rob(int[] nums) {
// if (nums == null || nums.length == 0)
// return -1;
// if (nums.length == 1)
// return nums[0];

// int[] dp = new int[nums.length + 1];
// dp[0] = 0;
// dp[1] = nums[0];

// for (int i = 2; i < dp.length; i++) {
// dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
// }
// return dp[dp.length - 1];
// }
// }

// Exhaustive approach - Time Limit Exceeded
// class Solution {
// public int rob(int[] nums) {
// if(nums==null || nums.length==0) return -1;
// return(helper(nums, 0, 0));
// }
// public int helper(int[] nums, int index, int amount){
// // base
// if(index>=nums.length) return amount;

// // logic
// // case 1: choose
// int case1 = helper(nums, index+2, amount+nums[index]);
// // case 2 : dont choose
// int case2 = helper(nums, index+1, amount);

// return Math.max(case1, case2);
// }
// }
