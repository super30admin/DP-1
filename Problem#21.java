// HOUSE ROBBER

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : - 


// Your code here along with comments explaining your approach

class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) // Cannot proceed if the array itself is not initialized or if there are no elements in the nums array
            return 0;
        if(nums.length == 1) // If there is only one house, rob that house
            return nums[0];
        int prev = nums[0]; // Previous will store the amount of money stashed in the house at index 0 initially
        int curr = Math.max(prev, 0 + nums[1]); // Current will store the maximum between the amount of money stashed in the previous house and the amount of money stashed in the current house plus 2 houses before, because this is just the second house, there will be no house 2 houses before this one, hence 0 is added
        for(int i = 2; i < nums.length; i++){ // Loop through all the houses starting from the third house, aka house at index 2
            int temp = curr; // Use a temp variable because the value of curr is being updated before assigning to prev
            curr = Math.max(curr, nums[i] + prev); // Current house is robbed only if the amount of money stashed 2 houses before plus the money here is greater than prev
            prev = temp; // Current house will be the previous one for the next iteration (amount of money is stored, depicting the house)
        }
        return curr; // Return the maximum amount
    }
}