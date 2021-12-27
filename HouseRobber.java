// Time Complexity : O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class HouseRobber {
    public int rob(int[] nums) {
        
    // Initialize dp array with 0 element to 0.
    int[] dp=new int[nums.length+1];
    
    dp[0]=0;
    dp[1]=nums[0];
    
    // For each element i+1, we have 2 options - ignore the present value - dp[i] or dp[i-1] + nums[i]. Choose the max of these values 
    for(int i=1;i<nums.length;i++)
    {
        dp[i+1]=Math.max(dp[i],dp[i-1]+nums[i]);
    }
    
    return dp[nums.length];
        
    }
}