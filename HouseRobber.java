// Time Complexity : O(2^n) where S is the amount
// Space Complexity :)O(n)
// Did this code successfully run on Leetcode : TLE
// Description: Recursive approach

class Solution{
	public int rob(int[] nums){
		return helper(nums, 0,0);
	}
	private int helper(int[] nums, int i, int maxAmount){
		//Base case
		if(i>= nums.length){
			return maxAmount;
		}
		//case 1 choose the current index
		int case1 = helper(nums, i+2, maxAmount + nums[i]);
		
		// case 2 dont choose
		int case2 = helper(nums, i+1, maxAmount);
		
		return Math.max(case1, case2);
	}
}


// Time Complexity :
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Description: DP approach
class Solution{
	public int rob(int[] nums){
		if(nums == null || nums.length == 0){
			return 0;
		}
		
		int chosen =0, notChosen =0;
		
		for(int i=0; i< nums.length; i++){
			int temp = chosen;
			chosen = notChosen + nums[i];
			notChosen = Math.max(temp , notChosen);
		}
		return Math.max(chosen , notChosen);
	}
}