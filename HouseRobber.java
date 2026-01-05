// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes. 

// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

public class HouseRobber {

	public int rob(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[0];
		if (nums.length == 2)
			return Math.max(nums[0], nums[1]);
		int cache[] = new int[nums.length];
		cache[0] = nums[0];
		cache[1] = nums[1];
		cache[2] = cache[0] + nums[2];

		for (int i = 3; i < nums.length; i++) {
			cache[i] = Math.max(nums[i] + cache[i - 2], nums[i] + cache[i - 3]);
		}
		return Math.max(cache[nums.length - 1], cache[nums.length - 2]);

	}
	
	
	// time complexity O(n)
	// Space complexity O(1)
	// just using two variable and temp variable to store prev robbed, this is more efficient
	/*public int rob(int[] nums) {
	      if (nums==null || nums.length==0)
	            return 0;
	      int robbed=0;
	      int notRobbed=0;
	      for (int i=0;i<nums.length;i++){
	          int pRobbed=robbed;
	          robbed=nums[i]+notRobbed;
	          notRobbed=Math.max(pRobbed,notRobbed);
	         
	        }
	        return Math.max(robbed,notRobbed);

		}*/
	
	
	public static void main(String[] args) {
		
	}

}
