//Time Complexity: O(n)
//Space Complexity: O(1) 
//Code run successfully on LeetCode.

public class Problem2_DP_2 {
	
	public int rob(int[] nums) {
		
		if(nums == null || nums.length == 0)
			return -1;
		
		int n = nums.length;
		int temp;
		int skip = 0;
		int take = nums[0];
		
		for(int i = 1; i < n; i++) {
			
			temp = skip;
			
			skip = Math.max(skip, take);
			take = temp + nums[i];
		}
        return Math.max(skip, take);
    }

}
