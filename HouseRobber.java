
// Time Complexity :O(N) because we traverse the whole array ones
// Space Complexity :O(1) because we use just two Variables
// Did this code successfully run on Leetcode :Yes

public class HouseRobber {
	  
	public int rob(int[] nums) {
	        int rob=0;
	        int noRob = 0;

	        for(int i=0;i<nums.length;i++){
	           int temp = noRob;
	           noRob = Math.max(noRob,rob);
	           rob = temp+nums[i]; 
	        }
	        return Math.max(rob,noRob);
	    }
}
