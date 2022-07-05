//Time Complexity : O(2^n)
//Space Complexity : O(n)
//Solution accepted on LeetCode, but Time Limit Exceeded due to Exhaustive Search.

public class Problem2_ExhaustiveSearch {

	 public int rob(int[] nums){
	        
		 if(nums == null || nums.length == 0)
			 return -1;
		 
		 return helper(nums,0,0);
	    }
	 
	 private int helper(int[] nums, int index, int robbedAmount) {
		 
		 if(index >= nums.length)
			 return robbedAmount;
		 
		 // do not choose the current house
		 int case1 = helper(nums, index +1, robbedAmount);
		 
		 //choose the current house
		 int case2 = helper(nums, index +2, robbedAmount + nums[index]);
		 
		 return Math.max(case1, case2);
	 }
	 
}
