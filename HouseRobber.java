//Time Complexity: O(n);where n is length array
//Space Complexity: O(1)
public class HouseRobber {
	public int rob(int[] nums) {
		if(nums==null || nums.length==0) return 0;
		if(nums.length==1) return nums[0];
		
		int robNextToNext=0;
		int robNext= nums[nums.length-1];
		
		//DP Bottom up
		for(int i=nums.length-2; i>=0; i--) {
			int curMaxAmt= Math.max(robNext, robNextToNext+nums[i]);
			robNextToNext= robNext;
			robNext= curMaxAmt;
		}
		return robNext;
	}
	
	public static void main (String[] args) {
		HouseRobber ob= new HouseRobber();
		int[] nums= {2,7,9,3,1};		
		System.out.println("Max amount can be robbed: "+ob.rob(nums));			
	}
}
