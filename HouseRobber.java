// Time Complexity :O(N) where n is the number of houses
// Space Complexity :O(N) 
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach:the maximum amount robbed until present house can be calculated by finding 
//the maximum of (amt[present]+amt[present-2],amt[present-1]) since if we select the present house to rob, we cannot select the previous
// house


class Solution {
    public int rob(int[] nums) {
     if(nums.length==0)
            return 0;
        if(nums.length==1)
            return nums[0];
        if(nums.length==2)
            return Math.max(nums[0],nums[1]);
        int[] dp = new int[nums.length];
        dp[0]= nums[0];
        dp[1] = Math.max(dp[0],nums[1]);
        for(int i=2; i< nums.length;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
            
        }
        
        return dp[nums.length-1];
    }
}