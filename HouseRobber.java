/**
Time Complexity : O(N) N = input size
Space Complexity : O(N) N = input size
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
**/
class Solution 
{
    public int rob(int[] nums) 
    {
        int length = nums.length;
        
        if(length ==1)
            return nums[0];
        
        int dp[] = new int[nums.length + 1];
        
        dp[0] = 0;
        dp[1] = nums[0];
        
        for(int i =1 ; i < length; i++)
        {
            dp[i+1] = Math.max(dp[i], dp[i-1] + nums[i]);
        }
        
        return dp[nums.length];
    }
}