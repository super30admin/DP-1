// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// 1. Recursive Approach (Exhaustive approach)

/**
 * For Every house, we either take a decision of robbing the house or not.
 * If we rob the house, we can not rob the next house, so we ignore the bext house
 * If we skip the current house, we explore the next house
 */

class Solution {
    public int rob(int[] nums) {
        return helper(nums, 0, 0);
    }
    
    private int helper(int[] houses, int index, int robbings) {
        // base case
        if(index >= houses.length) {
            return robbings;
        }
        
        // logic
        // choose the current house
        int case1 = helper(houses, index + 2, robbings + houses[index]);
        
        // don't choose the current house
        int case2 = helper(houses, index + 1, robbings);
        
        return Math.max(case1, case2);
        
    }
}

// 2. Dynamic Programming approach

/**
 * For Every house, we either take a decision of robbing the house or not.
 * If we rob the house, we can not rob the next house, so we ignore the bext house
 * If we skip the current house, we explore the next house
 */



class Solution2 {
    public int rob(int[] nums) {
        int[][] dp = new int[nums.length][2];
        // 0th column is for skipping the current house
        // 1st column is for choosing the current house

        // if we rob the first house, the robbing is the value of that house as it is the first house
        // if we do not rob the first house, the value is 0.
        dp[0][1] = nums[0];
        dp[0][0] = 0;

        for (int i=1;i<nums.length;i++) {
            // don't choose option (0th index)
            // Maximum of previous choose and don't choose option
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);

            // choose option (1st index)
            // previous don't choose option + current value
            dp[i][1] = dp[i-1][0] + nums[i];
        }

        return Math.max(dp[dp.length-1][1], dp[dp.length-1][0]);
    }
}

