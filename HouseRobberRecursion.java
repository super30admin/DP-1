public class HouseRobberRecursion {
    public int rob(int[] nums) {
        return helper(nums, 0, 0);
    }

    private int helper(int[] nums, int i, int count) {
        // base case
        if (i >= nums.length)
            return count;
        // No Choose
        int case0 = helper(nums, i + 1, count);
        // Choose
        int case1 = helper(nums, i + 2, count + nums[i]);

        return Math.max(case0, case1);
    }
}

/**
 * Exhaustive or recursion approach
 * TC: O(2^n)
 * SC: O(n)
 */

