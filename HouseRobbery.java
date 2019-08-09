
public class HouseRobbery {
	/**
	 * Recursion
	 * Time: O(2^n)
	 * @param nums
	 * @return
	 */
	public static int robRec(int[] nums) {
		return robRec(nums, 0, 0);
	}
	
	public static int robRec(int[] nums, int i, int max ) {
        //base case
		if(i >= nums.length) return max;
		//select ith element
		int case1 = robRec(nums, i+2, max+nums[i]);
		//don't select ith element
		int case2 = robRec(nums, i+1, max);
		return Math.max(case1, case2);
    }
	
	/**
	 * Dp
	 * Time: 2*O(n) => O(n)
	 * Space: O(n)
	 * @param nums
	 * @return
	 */
	public static int robDp(int[] nums) {
		if(nums.length == 0) return 0;
		int[][] arr = new int[nums.length][2];
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<2; j++) {
				if(i==0 && j==0) arr[i][j] = 0;
				else if(i==0 && j==1) arr[i][j] = nums[0];
				//If not selected return the max of prev values
				else if(j==0) arr[i][j] = Math.max(arr[i-1][0], arr[i-1][1]);
				//If selected return the sum of current value of prev not selected values
				else if(j==1) arr[i][j] = arr[i-1][0]+nums[i];
			}
		}
		return Math.max(arr[nums.length-1][0], arr[nums.length-1][1]);
	}
	
	/**
	 * Time: O(n)
	 * Space: O(1)
	 * @param nums
	 * @return
	 */
	public static int robDpOpt(int[] nums) {
		if(nums.length == 0) return 0;
		int temp;
		int sel = nums[0];
		int notsel = 0;
		for(int i=1; i<nums.length; i++) {
			temp = sel;
			sel = notsel + nums[i];
			notsel = Math.max(temp, notsel);
		}
		return Math.max(sel, notsel);
	}
	
	public static void main(String[] args) {
		int[] nums = {2, 7, 9, 3, 1};
		System.out.println(robRec(nums));
		System.out.println(robDp(nums));
		System.out.println(robDpOpt(nums));
	}
}
