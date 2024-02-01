// Time Complexity :  O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*Your code here along with comments explaining your approach
 * Started with exhaustive approach by either robbing a house or not
 * if you rob a house; you move to index + 2 (and add the money) else index + 1;
 * This lead to some repeated calculations which could be optimized by tabulation
 * For tabulation, I started from the end with only one house; if there's only one house;
 * we rob it; if two houses, we choose the bigger one; for the other indices; I take
 * Math.max(dp[nums.length - 1], nums[nums.length - 2]) because this is what I did while creating the tree as well
*/

// DP Solution
class Problem2 {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        // last 2 elements can be calculated manually
        // if there's only one house to rob; then max money to rob is the house value
        // if there's only two houses(adjacent) to rob; pick up the max of those two
        dp[nums.length - 1] = nums[nums.length - 1];
        if (nums.length > 1) {
            dp[nums.length - 2] = Math.max(dp[nums.length - 1], nums[nums.length - 2]);
        }

        // we start calculating from the back
        for (int i = dp.length - 3; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], nums[i] + dp[i + 2]);
        }

        return dp[0];
    }
}

// Recursive soln which TLEd
class RecursiveSolution {
    public int rob(int[] nums) {
        return robRecursive(nums, 0, 0);
    }

    public int robRecursive(int[] nums, int index, int money) {
        if (index >= nums.length)
            return money;

        // choose
        int choose = robRecursive(nums, index + 2, money + nums[index]);
        // dont choose
        int dontChoose = robRecursive(nums, index + 1, money);

        return Math.max(choose, dontChoose);
    }
}