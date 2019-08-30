/**
 * You are a professional robber planning to rob houses along a street. Each
 * house has a certain amount of money stashed, the only constraint stopping you
 * from robbing each of them is that adjacent houses have security system
 * connected and it will automatically contact the police if two adjacent houses
 * were broken into on the same night.
 * 
 * Space Complexity: O(n) 
 * Time Complexity: O(n)
 * 
 * Space Complexity can be reduced to O(1) constant space, as we only need to
 * remember the previous 2 values.
 * 
 * Leetcode Results: Runtime: 0 ms, faster than 100.00% of Java online
 * submissions for House Robber. 
 * Memory Usage: 34 MB, less than 100.00% of Java online submissions for House Robber.
 */
class HouseRobber {
    /**
     * The Decision of choosing the house to rob depends upon the previous two houses 
     * and maximizing the money.
     * 
     * @param nums non-negative integer array representing the money of each house
     * @return maximum amount of money you can rob tonight without alerting the
     *         police.
     */
    public int rob(int[] nums) {
        int len = nums.length;
        // base case checks
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }
        // using dynamic programming to store solutions to overlapping subproblems.
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            // should we choose nums[i] depends on whether nums[i] + dp[i-2] 
            // is optimal then dp[i-1]
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }
        return dp[len - 1]; // result
    }
}