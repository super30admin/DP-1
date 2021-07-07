//Time complexity is o(n) as we are iterating through the nums length which can be n
//Space complexity is O(1) i.e constanst space as we are not using any extra space apart from ints which is constant
//This code is submitted on leetcode

public class HouseRobberBigN20UsingTwoInteger {
	public int rob(int[] nums) {
		//edge
		if (nums.length == 0 || nums== null) {
			return 0;
		}
		int choosen = nums[0];
		int notChoosen  = 0;
		for (int i = 1; i< nums.length ; i++) {
			int temp = notChoosen;
			notChoosen = Math.max(choosen, notChoosen);
			choosen = temp + nums[i];
		}
		return Math.max(choosen, notChoosen);
	}

	public static void main(String[] args) {
		HouseRobberBigN20UsingDP house = new HouseRobberBigN20UsingDP();
		int [] nums = {1,3,2,1};
		house.rob(nums);
	}

}
