/**
 * Approach 1 - DP Tabulation
 * TC: O(n)
 * SC: O(n)
 */
public class HouseRobberDP {

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];

        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            // No Choose, choose
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }

        return dp[n - 1];
    }
}


/**
 * DP Approach 2 - using just 3 variable instead of an Array
 * TC: O(n)
 * SC: O(1)
 */
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];

        int prev = nums[0];
        int curr = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            int tmp = curr;
            // No Choose, choose
            curr = Math.max(curr, nums[i] + prev);
            prev = tmp;
        }

        return curr;
    }
}