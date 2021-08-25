// Time Complexity : O(n) where n is number of houses
// Space Complexity : O(n) where is n is number of houses
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class HouseRobbery {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0; //null check
        if(nums.length == 1) return nums[0]; //just one house
        if(nums.length == 2) return Math.max( nums[0], nums[1] ); //just two houses
        
        int[] dp = new int[nums.length];
        
        dp[0] = nums[0]; //1 house situation
        dp[1] = Math.max( nums[0], nums[1] ); //2 houses situation
        
        for(int i = 2; i < dp.length; i++) {
            dp[i] = Math.max( (nums[i] + dp[i - 2]), (dp[i-1]) );
            //either current house + dp of one skipped house before it
            //or the dp of immediate previous house
            //whichever is bigger
        }
        
        return dp[nums.length - 1];
        //last element of dp array will have the maximum possible robbery value
        
    }
}