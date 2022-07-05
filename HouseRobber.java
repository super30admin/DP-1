// Time Complexity : O(n) traverse given array
// Space Complexity : O(n) dp array - n rows and 2 columns
// Did this code successfully run on Leetcode : YES

class HouseRobber {
    public int rob(int[] nums) {
        
        if(nums==null || nums.length==0){
            return 0;
        }
        int dp[][]= new int[nums.length][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        
        
        for(int i =1;i<nums.length;i++){
        	//current not chosen - take max of previous chosen and not chosen
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]);
            // current chosesn - add previous not chosen and current value;
            dp[i][1] = dp[i-1][0]+nums[i];
        }
        
        //return max of accumulated chosen and not chosen
        return Math.max(dp[nums.length-1][0],dp[nums.length-1][1]);
    }
}