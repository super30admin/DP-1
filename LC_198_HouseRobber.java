// Time Complexity : O(n) -One for loop, but may be O(n-2) as 2 indexes are initialized before, not sure
// Space Complexity :O(n)- One array declared
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Math.max was not used for dp[1], hence one test case was failing
//TC={2,1}


// Your code here along with comments explaining your approach
public class LC_198_HouseRobber {
	public static void main(String[] args) {
		int[] nums = {1,2,3,1};
		System.out.println("Maximum Amount robbed: " + maxAmount(nums));
		
	}

	public static int maxAmount(int[] nums) {
		//Declare dummy array of same length as nums
		int len = nums.length;
		if(len == 0) return 0;
		if(len == 1) return nums[0];
		int[] dp= new int[len];
		//intialise first 2 indexes of dp array
		dp[0] = nums[0];
		//Set one which is maximum, as that house will be robbed
		dp[1]= Math.max(nums[0], nums[1]);
		for(int i = 2; i< len; i++) {
			dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
		}
		return dp[len-1];
	}
}
