import java.util.Arrays;

public class HouseRobber {
    // ---------------------- Solution 1 ------------------------
    /**
     * Tabulation 1D array DP optimized with only 2 variables
     * Time O(n) Space O(1)
     */
    public int rob1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int prev = nums[0];
        int curr = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            int temp = curr;
            curr = Math.max(curr, nums[i] + prev);
            prev = temp;
        }
        return curr;
    }

    // ---------------------------- Solution 2 -------------------------
    /**
     * Memoization DP solution
     * Time O(n) Space O(n)
     */
    int[] memo;
    public int rob(int[] nums) {
        this.memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return helper(nums, 0);
    }

    private int helper(int[] nums, int idx) {
        //base
        if (idx >= nums.length) return 0;

        if (memo[idx] != -1) return memo[idx];

        //logic
        //not choose
        int choice1 = helper(nums, idx + 1);

        //choose
        int choice2 = nums[idx] + helper(nums, idx + 2);

        memo[idx] = Math.max(choice1, choice2);
        return memo[idx];
    }
}
