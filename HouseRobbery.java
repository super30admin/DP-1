
//time complexity o(n)
//space complexity =o(n)
//id this code successfully run on Leetcode : yes
//Any problem you faced while coding this :no

public class HouseRobbery {
	public static int rob(int[] nums) {
		int length = nums.length;
		
		//if input array is empty
		if(length ==0) return 0;
		//if input contains only 1 house with amount then return max amount as amount of that house
		if(length ==1) return nums[0];
		//if two house with amount as input then return maximum amount between two house.
		if(length ==2) return Math.max(nums[0], nums[1]);
		
		int[] dp =new int[length];
		
		
		//initialize dp[0] and dp[1]
		dp[0] = nums[0];
		dp[1]=Math.max(nums[0], nums[1]);
		
		//fill the remaining position from index 2 onwards. 
		//adding current index value of input with value at dp[current index-2] and then comparing it with dp[current index-1] and 
		//store maximum value in dp[current index]
		
		for(int i=2; i<length;i++) {
			dp[i]=Math.max(nums[i]+dp[i-2], dp[i-1]);
		}
       
		//return last element of dp.
		return dp[length-1];
		
	}
	
	
	public static void main(String[] args) {
		int[] input = {1,2,3,1};
		int n = rob(input);
		
		
		System.out.println("maximum amount robber can rob is="+n);
	}

}
