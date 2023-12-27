
/*
* Approach:
*  1. Explore all possibilities through recursion.
* 
*  2. Recurrence relation:
        rob at index  0 = max{
                            rob at index 2,
                            rob at index 3,
                            rob at index 4,....
                            }
    Base condition:
        index out of range return 0;
* 
*  3. As we are having overlapping subproblems, apply DP.
* 
*  4. As we might get max value if we start robbing from index 0 or 1,
        so we have to chance both the possibilites.
* 
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(n) 
* 
* Space Complexity: O(n) + O(n)
        problems + recursion stack
* 
*/
import java.util.Arrays;

class HouseRobber {
    private int rob(int[] nums, int index, int[] dp) {
        if (index >= nums.length)
            return 0;

        if (dp[index] != -1) {
            return dp[index];
        }

        dp[index] = nums[index];

        for (int i = index + 2; i < nums.length; i++)
            dp[index] = Integer.max(dp[index], nums[index] + rob(nums, i, dp));

        return dp[index];
    }

    public int rob(int[] nums) {
        int[] dp = new int[nums.length];

        Arrays.fill(dp, -1);

        return Integer.max(rob(nums, 0, dp), rob(nums, 1, dp));
    }
}