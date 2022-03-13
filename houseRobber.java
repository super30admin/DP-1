// Time Complexity : O(n) ,where n is the no. of houses in nums array
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//CODE

public class houseRobber {
    public int rob(int[] nums) {
        if(nums == null || nums.length ==0) return 0;  //null case
        if(nums.length ==1) return nums[0];
        
        int[][] dp = new int[nums.length][2];  
        dp[0][1]=nums[0];  //amount robbed in the first house will be equal to value of nums[0]
        
        for(int i=1 ; i<nums.length;i++){
            //not choose case
            dp[i][0] = Math.max(dp[i-1][0] , dp[i-1][1]);  //taking max of previous choose and not choose case
            //choose case
            dp[i][1] = nums[i] + dp[i-1][0];    //choose case will be made by not choosing previous i.e. previous not choose case and adding it to current index value
        }
        return Math.max(dp[nums.length-1][0] , dp[nums.length-1][1]);  //returning max of last row
}
}


//brute force -> exponential

class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length ==0) return 0;
        
        return helper(nums,0,0);
    }
    private int helper(int[] nums , int index , int robbed){
        //base
        if(index>=nums.length) return robbed;
        
        //logic
        //choose
        int case1 = helper(nums , index+2 , robbed+nums[index]);
        //not choose
        int case2 = helper(nums , index+1 , robbed);
        
        return Math.max(case1 , case2);
    }
}