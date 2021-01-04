// Time Complexity: O(N)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Figuring out that the DP array would represent the number of houses at each index. 


// Your code here along with comments explaining your approach

class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        if(nums.length == 1){
            return nums[0];
        }
        
        if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i = 2; i < dp.length; i++){
            dp[i] = Math.max(nums[i]+dp[i-2], dp[i-1]);
        }
        
        return dp[nums.length-1];
    }
}