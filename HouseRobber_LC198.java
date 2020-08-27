/**
 * Use Dynamic Programming memoization and initialize a dp array with size n+1
 * such that ith index will correspond to stealing ith house
 * 0th index: no house, 1st index: 1st house, ..., nth index: nth house
 *
 * For maximizing dollars, go bottom up filling max stolen value at ith index of dp array
 * At any point use previously calculated max robbed value and find maximum of including current house or including previous
 */

// Time Complexity: O (N)
// Space Complexity: O (N) due to memoization
// Did this code successfully run on Leetcode : Yes
public class HouseRobber_LC198 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)   // Handling empty input
            return 0;

        int[] dp = new int[nums.length + 1];    // DP array
        dp[0] = 0;                              // Stealing 0 houses
        dp[1] = nums[0];                        // Stealing 1st house
        for (int i = 1; i < nums.length; i++) {
            dp[i + 1] = Math.max(dp[i], dp[i - 1] + nums[i]);       // Max of previous and including ith house or not
        }
        // Last index will have maximum robbed value contributed by optimal at each step before
        return dp[nums.length];
    }
}
