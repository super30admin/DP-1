/*
 * Time Complexity - Recursive: O(2^n), where n = number of houses
 * Time Complexity - DP: O(n), where n = number of houses
 * 
 * Space Complexity - Recursive: O(n) due to recursion stack
 * Space Complexity - DP: O(n) for the dp array
 * 
 * Approach -
 * Recursive (House Robber II - Circular):
 * - I consider two cases separately to handle the circular condition:
 *     1. Include the first house, exclude the last
 *     2. Exclude the first house, include the last
 * - For each case, I recursively decide to either rob or skip the current house.
 * - At each step, I take the max of:
 *     - Skipping the current house (go to idx + 1)
 *     - Robbing the current house (add its value + skip next house → idx + 2)
 * 
 * DP (House Robber I - Linear):
 * - I use a 1D dp array where dp[i] stores the maximum amount that can be robbed up to house i.
 * - Base cases:
 *     - dp[0] = nums[0]
 *     - dp[1] = max(nums[0], nums[1])
 * - Transition:
 *     - dp[i] = max(dp[i-1], dp[i-2] + nums[i])
 * - Final answer is stored in dp[n-1], representing the best total up to the last house.
 */

public class Problem_2 {

    static int house_robber_recursive(int[] nums) {
        int zero_index = helper(nums, 0, true);
        int first_index = helper(nums, 1, false);
        System.out.println(zero_index);
        System.out.println(first_index);
        return 0; // Math.max(zero_index, first_index);

    }

    static int house_robber_dp(int[] nums) {
        int[] dp = new int[nums.length];
        if (nums.length <= 0) {
            return 0;
        }
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }

    static int helper(int[] nums, int idx, boolean is_zero) {
        if (idx >= nums.length) {
            return 0;
        }
        if ((idx == nums.length - 1) && (is_zero == true)) {
            return 0;
        }
        if ((idx == 0) && (is_zero == false)) {
            return 0;
        }
        int a = helper(nums, idx + 1, is_zero);
        int b = nums[idx] + helper(nums, idx + 2, is_zero);
        return Math.max(a, b);
    }

    public static void main(String[] args) {
        int[] nums_1 = { 2, 3, 2 };
        int[] nums_2 = { 1, 2, 3, 1 };
        System.out.println(house_robber_recursive(nums_1));
        System.out.println(house_robber_recursive(nums_2));
        // System.out.println(house_robber_dp(nums_1));
        // System.out.println(house_robber_dp(nums_2));
    }
}
