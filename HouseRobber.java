// Time Complexity : O(n) where n is number of houses
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Had to revise basic syntax

// ## Problem2 (https://leetcode.com/problems/house-robber/)

// You are a professional robber planning to rob houses along a street.
// Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have 
// security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
// Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
// Example 1:
// Input: nums = [1,2,3,1]
// Output: 4
// Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
// Total amount you can rob = 1 + 3 = 4.

// Example 2:
// Input: nums = [2,7,9,3,1]
// Output: 12
// Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
// Total amount you can rob = 2 + 9 + 1 = 12.
 
// Constraints:
// 1 <= nums.length <= 100
// 0 <= nums[i] <= 400


class Solution {
    public int rob(int[] nums) {
        // Base case: No houses to rob
        if(nums == null || nums.length == 0){
            return 0;
        }

        // skip => max amount robbed if current house is skipped
        // max => max amount robbed if current house is taken
        // Initializing both variables for 1st element in nums
        int skip = 0, take = nums[0];

        for (int i = 1; i < nums.length; i++){
            int tempSkip = skip;
            skip = Math.max(skip, take); // skipping current house, take max of previous skip and take
            take = tempSkip + nums[i]; // taking current house, adding its value to previous skip
        }

        // return max of skipping or taking the last house
        return Math.max(skip, take);
    }
}
