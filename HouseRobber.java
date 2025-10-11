// 198. House Robber
// https://leetcode.com/problems/house-robber/description/

// Solution 1 => Recursion (TLE)

/**
 * Time Complexity: O(2 ^ n), since at every level we give 2 calls and we have levels till n is exhausted
 * Space Complexity: O(n), levels in a tree
 */

class Solution {
    public int rob(int[] nums) {
        return helper(nums, 0);
    }

    private int helper(int [] nums, int idx){

        // base condition
        if(idx >= nums.length){  // if we have no element left to process
            return 0;
        }
             
        // if we don't pick current house, we move ahead by 1
        // if we pick current house, we can't select next house. Hence move forward by 2
        return Math.max(helper(nums, idx + 1), nums[idx] + helper(nums, idx + 2));  
    }
}

// Solution 2 => Memoization/Top down

/**
 * Time Complexity: O(n), 
 * Space Complexity: O(n), levels in a tree
 */

class Solution {

    public int rob(int[] nums) {

        int [] dp = new int[nums.length];
        
        for(int i = 0 ; i < nums.length ; i++){ // initialize dp with -1 o(n)
            dp[i] = -1;
        }

        return helper(nums, 0, dp);
    }

    private int helper(int [] nums, int idx, int [] dp){

        // base condition

        if(idx >= nums.length){
            return 0;
        }

        if(dp[idx] != -1){    // if this index is not -1, we have already calculated max amount at this index
            return dp[idx];
        }

        dp[idx] = Math.max(helper(nums, idx + 1, dp), nums[idx] + helper(nums, idx + 2, dp));

        return dp[idx];
    }
}

// Solution 3 => Bottom-up/Tabulation

/**
 * Time Complexity: O(n), 
 * Space Complexity: O(n), since we have n size dp array
 */


class Solution {
    public int rob(int[] nums) {
        int [] dp = new int[nums.length + 1]; // + 1 as we want to store initial amount of 0th house

        dp[0] = 0;
        dp[1] = nums[0]; // At first house, max amount is amount at same house

        for(int i = 1 ; i < nums.length ; i++){
            dp[i + 1] = Math.max(dp[i - 1] + nums[i], dp[i]); // get min. between (current amt + max amt at 2 houses back) and (previous house)
        }

        return dp[nums.length];
    }
}
