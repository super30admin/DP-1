// Time Complexity : O(n), where n is the number of houses
// Space Complexity : O(1), we use only two variables to store previous states
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach:
// This is a space-optimized Dynamic Programming solution.
// We use two variables to track the maximum money robbed up to the previous and current house.
// At each step, we decide whether to rob the current house (and add to the value from two houses back)
// or skip it and keep the maximum from the previous house.

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        // If there's only one house, rob it
        if (n == 1) return nums[0];

        // Initialize the first two choices
        int prev = nums[0]; // max money robbable up to house 0
        int curr = Math.max(nums[0], nums[1]); // max money robbable up to house 1

        for (int i = 2; i < n; i++) {
            int temp = curr;
            // Either rob this house and add to prev, or skip it and take curr
            curr = Math.max(curr, nums[i] + prev);
            prev = temp;
        }

        // Return the maximum money robbed
        return curr;
    }
}