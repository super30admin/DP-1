// Time Complexity :O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class HouseRobber
{
    public int rob(int[] nums) {
        //base case
        if(nums.length==0)
            return 0;
       int [] dp = new int[nums.length+1];
        dp[1]= nums[0];
       for(int i = 2;i<dp.length;i++)
       {
           dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i-1]);
       }
       return dp[nums.length];
    }

}