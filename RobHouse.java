// Time Complexity : O(n) , n is the number of houses
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Solution {
    public int rob(int[] nums) {
        
        //check base cases
        if(nums == null || nums.length ==0) 
            return 0; 
        if(nums.length ==1) 
            return nums[0];
        
        int[][] dp = new int[nums.length][2];  
        dp[0][1]=nums[0];  //starting with the amount of the first house
        
        for(int i = 1 ; i < nums.length ; i++ ){
            //not choose case
            dp[i][0] = Math.max(dp[i-1][0] , dp[i-1][1]);
            //choose case
            dp[i][1] = nums[i] + dp[i-1][0];
        }
        return Math.max(dp[nums.length-1][0] , dp[nums.length-1][1]);  
}
}
