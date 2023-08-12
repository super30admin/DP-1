// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    public int rob(int[] nums) {
       if(nums== null || nums.length==0)
       {
           return -1;
       }
        if(nums.length==1) return nums[0];
       int[] dp= new int[nums.length];
       dp[0]=nums[0];
       dp[1]= Math.max(nums[1],dp[0]);
       for(int i=2; i<dp.length;i++)
       {
           int rob = nums[i]+dp[i-2]; // take it add it with previous i-2th element
           int notRob =  0+dp[i-1]; //not taking it?? so just copy before sum
          dp[i]= Math.max(rob,notRob);
       }
       return dp[nums.length-1];
    }
}
