
public class HouseRobber {

	// TC: o(n)
	// SC: o(n)
	// use array to store
	public int rob(int[] nums) {

		if (nums == null || nums.length == 0)
			return 0;

		int n = nums.length;
		int[] dp = new int[n];
		if (n == 1)
			return nums[0];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);
		for (int i = 2; i < n; i++) {
			dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
		}
		return dp[n - 1];
	}

	// TC: o(n)
	// SC: o(1)
	// we use two variables here to keep track of current and previous
	// and check for each house rob and not rob case and take the max of both
	public int robWithVaribles(int[] nums) {

		if (nums == null || nums.length == 0)
			return 0;

		int n = nums.length;
		if (n == 1)
			return nums[0];
		int prev = nums[0];
		int curr = Math.max(nums[0], nums[1]);
		for (int i = 2; i < n; i++) {
			int temp = curr;
			curr = Math.max(curr, nums[i] + prev);
			prev = temp;
		}
		return curr;
	}

	// TC: 2^n
	// SC: 2^n
	public int robExhaustive(int[] nums) {

		if (nums == null || nums.length == 0)
			return 0;

		return helper(nums, 0, 0);
	}

	private int helper(int[] nums, int i, int amount) {
		// base
		if (i >= nums.length)
			return amount;
		// logic
		// case 1 choose
		int case1 = helper(nums, i + 2, amount + nums[i]);

		// case 0 not choosechoose
		int case0 = helper(nums, i + 1, amount);

		return Math.max(case1, case0);
	}

}
