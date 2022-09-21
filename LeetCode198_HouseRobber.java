//Recursion - exhausted approach - choose , not choose
//space - exponential
//time - exponentials


class Solution {
    public int rob(int[] nums) {
			if(nums == null || nums.length == 0) return 0;
			
			return helper(nums, 0, 0);
    }
	private int helper(int[] nums, int index, int money)
	{
		//base case
		if(index >= nums.length) return money;
		
		//not choose
		int case1 = helper(nums, index+1, money);
		
		//choose
		int case2 = helper(nums, index+2, money + nums[index]);
		
		return Math.max(case1, case2);
	}
}

//Optimized approach//DP
//Using two vars - Skip and take, uodate it at every instance of array. 
//TC- O(n) -- only traversing through the length of the nums array
//sc- constant, as we are just using two vars. 

class Solution {
    public int rob(int[] nums) {
			if(nums == null || nums.length == 0) return 0;
			
			int skip =0, take = nums[0];
			
			for(int i =1; i < nums.length; i++)
			{
				int temp = skip;
				
				//do not choose
				skip = Math.max(skip, take);
				
				//choose
				take = temp + nums[i];
			}
			return Math.max(skip, take);
    }
	
}


//using 2*n matrix, column represents the house
//space - O(n) -- as m is just 2; O(2*n) == O(n)
//Time - O(n); -- traversing through the house array

class solution
{
	private int rob (int nums[])
	{
		if(nums == null || nums.length == 0)
			return 0;
		
		int[][] dp = new int[2][nums.length];
		
		dp[0][0] = 0;
		dp[1][0] = nums[0];
		
		
		for(int j=1; j< nums.length; j++)
		{
			//not choose
			dp[0][j] = Math.max(dp[0][j-1], dp[1][j-1]);
			
			//choose
			dp[1][j] = nums[j] + dp[0][j-1];
		}
		return Math.max(dp[0][nums.length -1], dp[1][nums.length -1] );
	}
}


//using n*2 matrix, house on the row side and choose, not choose on column side. so just 2 columns
//space - O(m*2) = m= length of nums, 2== deciding factor of choose and not choose so it is O(m);
//tC: O(m);-- traversing through the nums array 

class Solution
{
	private int rob (int nums[])
	{
		if(nums == null || nums.length ==0) return 0;
		
		int[][] dp = new int[nums.length][2];
		
		dp[0][0] = 0; 
		dp[0][1] = nums[0];
		
		for(int i =1; i< nums.length; i++)
		{
			//not choose
			dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
			
			//choose
			dp[i][1] = nums[i] + dp[i-1][0];
		}
		
		return Math.max(dp[nums.length-1][0], dp[nums.length-1][1]);
	}
}