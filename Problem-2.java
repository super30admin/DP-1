/**
 * Approach:
 * - This is a variation of the maximum sum of non-adjacent elements (House Robber problem).
 * - Use two variables:
 *   - `prevRob`: max amount robbed till the previous house (excluding the last one).
 *   - `maxRob`: max amount robbed including the last house.
 * - For each house:
 *   - Either rob it (add its value to `prevRob`) or skip it (keep `maxRob` as is).
 *   - Update `maxRob` with the maximum of the two options.
 * - At the end, `maxRob` contains the maximum money that can be robbed without alerting the police.
 */
// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int rob(int[] nums) {
        int prevRob = 0;  // Max amount robbed till house i-2
        int maxRob = 0;   // Max amount robbed till house i-1
        for (int curValue : nums) {
            // Choose max between robbing current house or skipping it
            int temp = Math.max(maxRob, prevRob + curValue);
            prevRob = maxRob;  // Update prevRob for next iteration
            maxRob = temp;     // Update maxRob to current best
        }
        return maxRob; // Return the max amount robbed
    }
}
