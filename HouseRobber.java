/* Time Complexity : O(n))
 * 	n - length of the input array - nums*/
/* Space Complexity : O(1)*/
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//DP solution
public class HouseRobber {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        int n = nums.length;
        if(n == 1) return nums[0];
        int prev = nums[0];
        int curr = Math.max(nums[0], nums[1]);
        for(int i = 2; i < n; i++){
        	
        	//Max of(value in dp at index - 1(Max at previous index),
        	// value at curr. index +  value in dp at index - 2(Max at last to last index))
            int temp = curr;
            curr = Math.max(curr, nums[i] + prev);
            prev = temp;
        }
        return curr;
    }
}


/*

/* Time Complexity : O(n))
 * 	n - length of the input array - nums*/
/* Space Complexity : O(n)*/


//DP solution
/*
public class HouseRobber {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        int n = nums.length;
        if(n == 1) return nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < n; i++){
        	//Max of(value in dp at index - 1(Max at previous index),
        	// value at curr. index +  value in dp at index - 2(Max at last to last index))
            dp[i] = Math.max(dp[i-1], nums[i] + dp[i-2]);
        }
        return dp[n-1];
    }
}

*/


/*

/* Time Complexity : O(2^n))
 * 	n - length of the input array - nums*/
/* Space Complexity : O(1) - no auxiliary DS used*/
 
 
 //Exhaustive Solution
/*
public class HouseRobber {
	public int rob(int[] nums) {
		if(nums == null || nums.length == 0) return 0;
		return helper(nums, 0, 0);
	}

	private int helper(int[] nums, int index, int maxAmtRobbed) {
		// base condition
		if (index >= nums.length)
			return maxAmtRobbed;

		// choose
		//curr. house robbed ==> adjacent house cannot be robbed ==> index to be incremented by 2 and maxAmtRobbed is updated by adding the value at curr. index
		int case1 = helper(nums, index + 2, maxAmtRobbed + nums[index]);
		// not choose
		//curr. house not robbed ==> index to be incremented by 1 and maxAmtRobbed remains same
		int case2 = helper(nums, index + 1, maxAmtRobbed);
		return Math.max(case1, case2);
	}

}


*/