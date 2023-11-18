// Time Complexity : DP : O(n), Recursion: O(2^n)
// Space Complexity : DP ARRAY : O(n), DP variables: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Using DP, use Choose or No choose approach. If an element is chosen, then max sum until that point will be current element +
 * max sum at 2 index back. If an element is not chosen, then the max sum will be same as that of 1 index back. Calculate both,
 * and find the max between them.
 */

class Solution {
    public int rob(int[] nums) {

        // return helper(nums, 0, 0);
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];

        // int[] dp = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
//        int prev = nums[0];
//        int current = Math.max(nums[0], nums[1]);

        for(int i=2; i<nums.length; i++) {
//            int temp = current;
//            current = Math.max(current, prev+nums[i]);
//            prev = temp;
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
        }

        return dp[nums.length-1];
//        return current;
    }

//     private int helper(int[] nums, int index, int amount) {

//         //base
//         if(index >= nums.length) return amount;

//         //logic
//         int case0 = helper(nums, index+1, amount);
//         int case1 = helper(nums, index+2, amount+nums[index]);

//         return Math.max(case0, case1);
//     }
}