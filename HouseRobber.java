// Time Complexity :  O(N)  N--> number of houses
// Space Complexity :  O(1)
// Did this code successfully run on Leetcode :  Yes
// Any problem you faced while coding this : Yes

public class HouseRobber{
	
	public int rob(int[] nums) {

        //checking whether the input array is not empty
		if(nums==null || nums.length==0) {
			return 0;
		}
		
		//declaring two variables, one to rob and other to not rob
		
		int skip =0;
		int take = nums[0];
		
        //looping through the input array to get skip and take for each house

		for(int i=1;i<nums.length;i++) {
			int temp = Math.max(skip,take);     
			take = skip+nums[i];                 
			skip = temp;
		}
		
		return Math.max(skip, take);          //returning max out of skip and take
	}
	
	public static void main(String[] args) {
		HouseRobber ob = new HouseRobber();
		int[] nums = {1,2,3,1};
		System.out.println(ob.rob(nums));
	}
}