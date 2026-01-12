// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No, just needed to track previous two states.


// Your code here along with comments explaining your approach in three sentences only
// At each house, we decide either to rob it and add value to dp[i-2] or skip it and take dp[i-1].
// I only keep two variables to represent previous two states instead of full dp array.
// This gives maximum money that can be robbed without taking adjacent houses.

class Solution {
    public int rob(int[] nums) {

        int prev2 = 0; // dp[i-2]
        int prev1 = 0; // dp[i-1]

        for (int n : nums) {
            int curr = Math.max(prev1, prev2 + n);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}
