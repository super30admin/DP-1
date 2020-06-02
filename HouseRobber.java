// Time Complexity : O(n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Bottom up approach

class Solution {
    public int rob(int[] nums) {
        //edge case
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1){// If 1 house, rob that 1 house
            return nums[0];
        }
        if(nums.length == 2){// If 2 houses, rob max amount of the house.
            return Math.max(nums[0], nums[1]);
        }
        
        int[] dp = new int[nums.length];
        dp[0] = nums[0];// 0 house, 0 money
        dp[1] = Math.max(nums[0], nums[1]);// 1 house, Max of 0 and 1
        for(int i = 2; i<dp.length; i++){
            dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);// Max of non-adjacent house.
        }
        return dp[nums.length - 1];
    }
}