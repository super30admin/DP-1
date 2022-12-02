// Time Complexity : O(2^n) , n is length of the array
// Space Complexity : O(2^n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/* The exhaustive recursive solution gave a time limit excess  */

class Solution {
    public int rob(int[] nums) {

        // check for null condition
        if (nums == null || nums.length == 0)
            return 0;

        int n = nums.length;
        // send the array and the last index to the helper function
        return helper(nums, n - 1);
    }

    private int helper(int[] nums, int index) {
        // base
        if (index < 0)
            return 0;

        if (index == 0)
            return nums[0];

        // case 1 -> pick element

        int case1 = nums[index] + helper(nums, index - 2);

        // case 2 -> not pick element

        int case2 = helper(nums, index - 1);

        // return the maximum
        return Math.max(case1, case2);
    }
}

// Time Complexity : O(n) , n is length of the array
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/* DP bottom up approach */

class Solution {
    public int rob(int[] nums) {

        if (nums == null || nums.length == 0)
            return 0;

        int m = nums.length;

        // if only one element
        if (m == 1)
            return nums[0];

        // if only 2 house, select house with max money
        if (m == 2)
            return Math.max(nums[0], nums[1]);

        // create 1D array for DP of length m
        int[] dp = new int[m];

        // add the hums element to dp[0] and dp[1].
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        // run till last element and see if we get the maxium money without being next
        // to each other
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }

        return dp[m - 1];
    }
}