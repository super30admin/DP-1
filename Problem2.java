// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


class Solution {
    public int rob(int[] nums) {
        //return 0 if the elemensts are empty
        if(nums.length ==0 || nums == null)
        {
            return 0;
        }
        
        //if only one element is present
        if(nums.length ==1)
            return nums[0];
        
        int[] dp = new int[nums.length]; //create a dp array which is same as that of the given array
        
        //now we have two pick either the firt element or the second element so that the robber can start robbing the house
        dp[0]=nums[0]; //first house
        dp[1]=Math.max(nums[0],nums[1]); //picking which house will give maximum money out of first two houses
        
        
        //iterating for rest of the houses after the first house is picked by the robber 
        for(int i=2;i<nums.length;i++)
        {
            //now we have to progress further to find the maximum money
            // In the below statement we are checking that when we choose the next house, it should not be an adjacent house and the money should be maximum 
            dp[i] = Math.max(nums[i]+dp[i-2],dp[i-1]);
        }
        
        return dp[nums.length-1]; //return the total sum
        
    }
}