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

public class HouseRobberRecursive {

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
		return findMaxRobbings(nums,0,0);
	}
	
	private static int findMaxRobbings(int[] nums, int index, int maxRobbings) {
		
		
		if(index >= nums.length) return maxRobbings;
		//case 1 choose the coin
		int case1 = findMaxRobbings(nums,index+2,maxRobbings+ nums[index]);
		//case 2 not choose
		int case2 = findMaxRobbings(nums,index+1,maxRobbings );
		
		return Math.max(case1, case2);
		
	}

}
