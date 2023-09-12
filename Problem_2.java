/* 

Problem2 (https://leetcode.com/problems/house-robber/)

Time Complexity : O(n)
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

*/

//Use extra array to store DP values

class Solution {
    public int rob(int[] nums) {
        
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int[] dp = new int[nums.length+1];
        dp[1] = nums[0];
        for(int i=2; i<dp.length; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i-1]);
        }

        return dp[nums.length];
    }
}


// Using 2 variables instead of an array using DP. Space Complexity : O(1). TC remains the same

class Solution_1 {
    public int rob(int[] nums) {
        
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int take = nums[0];
        int skip = 0;
        
        for(int i=1; i<nums.length; i++){
            int temp = skip;
            skip = Math.max(temp, take);
            take = temp + nums[i];
        }

        return Math.max(skip,take);
    }
}
