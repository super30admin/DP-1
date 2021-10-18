public class HouseRobber {
    public int rob(int[] nums) {
        return helper(nums, 0);
    }

    public int helper(int[] nums, int index) {
        if (index >= nums.length) {
            return 0;
        }
        int robbed = nums[index] + helper(nums, index + 2);
        int notRobbed = helper(nums, index + 1);
        return Math.max(robbed, notRobbed);
    }

}
