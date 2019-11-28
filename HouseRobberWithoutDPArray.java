public class HouseRobberWithoutDPArray {
	//	Time:  O(m*n) 
	//	Space O(1) 
	//	LeetCode: yes
	public int rob(int[] nums) {
		if(nums.length==0 || nums == null ) return 0;
		int chosen = nums[0];
		int notChosen = 0;
		for(int i=0 ; i < nums.length; i++) {
			int temp = chosen;
			chosen = nums[i] + notChosen;
			notChosen = Math.max(notChosen, temp);
		}
		return 0;
	}
}