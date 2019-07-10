package day7;

//Time Complexity : O(n) where n is the length of house array
//Space Complexity : O(n) where n is the length of dp array
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this : Took time to understand the solution


//Your code here along with comments explaining your approach

public class HouseRobber {
	public int rob(int[] houseArr) {
		
	if(houseArr.length == 0) return 0;
    if(houseArr.length == 1) return houseArr[0];

    // Initialize an array to store the money
	int[] dp = new int[houseArr.length];

    // We can infer the formula from problem: dp[i] = max(houseArr[i] + dp[i-2], dp[i-1])
    // so initialize two nums at first.
	dp[0] = houseArr[0];
	dp[1] = Math.max(houseArr[0], houseArr[1]); // base condition

    // Using Dynamic Programming to find and save the max money in loop.
	for(int i = 2; i < houseArr.length; i++){
		// find the maximum sum between the current house and the previous house
		// and save the max value against that house index.
		dp[i] = Math.max(houseArr[i] + dp[i - 2], dp[i - 1]);
	}
	return dp[houseArr.length - 1];
	
	}
	
	/////// Space complexity : O(1) from Leetcode
	/*
	 public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int now  = 0;
        int last = 0;
        
        for (int i=0; i<nums.length; i++) {
            int temp = last;
            last = now;
            now  = Math.max(now,nums[i]+temp);
        }
        return now;
    }
	 */
}
