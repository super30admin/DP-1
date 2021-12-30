package dp1;

public class HouseRobber {
	//Time Complexity : O(n), where n is the length of array nums
	//Space Complexity : O(n)
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	
	//Loop from 0 to nums.length - 1
	public int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[1] = nums[0];
        
        for(int i=1; i<nums.length; i++)
            dp[i+1] = Math.max(dp[i], nums[i] + dp[i-1]);
        
        return dp[nums.length];
    }
	
	//Loop from nums.length - 1 to 0
	public int rob1(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[nums.length - 1] = nums[nums.length -1 ];
        
        for(int i=nums.length - 2; i>=0; i--)
            dp[i] = Math.max(dp[i + 1], nums[i] + dp[i+2]);
        
        return dp[0];
    }
}
