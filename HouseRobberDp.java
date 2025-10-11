/**
 * Leet Code: https://leetcode.com/problems/house-robber/description/
 *
 * Approach:
 * This is a classic dynamic programming problem. The idea is to use a dp array where dp[i] represents
 * the maximum amount of money that can be robbed from the first i houses. For each house, you have two choices:
 *   1. Do not rob the current house, in which case the answer is dp[i-1].
 *   2. Rob the current house, in which case you add the current house's money (nums[i-1]) to dp[i-2].
 * The recurrence relation is: dp[i] = max(dp[i-1], nums[i-1] + dp[i-2])
 *
 * Time Complexity: O(N), where N = number of houses. Each house is processed once.
 * Space Complexity: O(N) for the dp array.
 */
public class HouseRobberDp {

    public int rob(int[] nums) {
        // dp[i] represents the max money that can be robbed from the first i houses
        int[] dp = new int[nums.length+1];
        dp[0] = 0; // No houses to rob
        dp[1] = nums[0]; // Only one house to rob
        for(int i =2; i< dp.length ;i++){
            // For each house, choose to rob it (and add dp[i-2]) or skip it (dp[i-1])
            dp[i] = Math.max(dp[i-1], nums[i-1] + dp[i-2]);
        }
        return dp[dp.length-1]; // The answer is the max money after considering all houses
    }

    public static void main(String[] args) {
        System.out.println(new HouseRobberDp().rob(new int[]{2, 1, 1, 2}));
    }
}
