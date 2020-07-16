// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


public class House_Robber {
	public static int rob(int[] nums) {
        if(nums == null || nums.length ==0)		// if given arrray is null or length = 0 , return 0
            return 0;
        
        if(nums.length == 1)				// if given array length(amount of money of each house) is 1, then just return the same
            return nums[0];
        if(nums.length == 2)				// if given array length(amount of money of each house) is 2, then return the max of two values 
            return Math.max(nums[0], nums[1]);	
        
        int[] dp = new int[nums.length];		// initializing a 1d array
         dp[0] = nums[0];						//considering first house is most I can rob
         dp[1] = Math.max(nums[0], nums[1]);      //to consider second house, find the max of first and second house
        for(int i=2; i<nums.length; i++)		// to consider from 3rd house, will find the max of (i-2 + i and i-1) 
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        
        
        return dp[nums.length -1];			// return the max value
    }

	public static void main(String[] args) {
		int[] nums = {1,2,3,1};
		System.out.print(rob(nums));
	}

}
