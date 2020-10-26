//Time Complexity : O(n)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : 

class House_Robber_DP_198 {
	public int rob(int[] nums) {
		if(nums == null || nums.length == 0)
			return 0;
		
		int rob = nums[0];
		int doNotRob = 0;
		
		for(int i = 1; i < nums.length; i++)
		{
			int temp = doNotRob;
			// Do not rob
			doNotRob = Math.max(doNotRob, rob);
			
			// Rob
			rob = temp + nums[i];
		}
		return Math.max(doNotRob, rob);
	}
	public static void main(String[] args)
    {
    		int[] arr = {2,7,9,8,1};
    		House_Robber_DP_198 robbing = new House_Robber_DP_198();
    		System.out.println(robbing.rob(arr));    	
    }
}
