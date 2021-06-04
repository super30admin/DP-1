package DP1;
//Time Complexity : o(2^n) - n is no.of coins
//Space Complexity :o(n) 
//Did this code successfully run on Leetcode :Yes
//Any problem you faced while coding this :No

//Your code here along with comments explaining your approach
//trying greedy approach by taking max value always does not work here for all cases
//we can build a tree just making decision of choosing house or not
//recursion - house can be either choosen(case 1) or not chossen(Case 0)
// constraint is only houses, alt houses to be considered

public class HouseRobberDP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,1};
		
		int money = robHouse(nums);
		
		System.out.println(money);
	}

	public static int robHouse(int[] nums) {
		// TODO Auto-generated method stub
		//null case
		if(nums == null || nums.length == 0) return 0;
		
		int[][] dp = new int[nums.length][2];
		
		dp[0][1] = nums[0];
		
		for(int i =1; i<dp.length; i++) {
			//not choose the house
			dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
			//choose the house
			dp[i][1] = dp[i-1][0] + nums[i];
			}
		return Math.max(dp[dp.length-1][0], dp[dp.length-1][1]);
		}
		
}
