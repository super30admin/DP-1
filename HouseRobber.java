// Time Complexity : O(n), where n=input set's length, m=amount
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/**
 * For recursive soln, we go exhaustive, i.e. we re-calculate the output of
 * pre-calculated same sub-problem. TC => O(2^n)
 * To optimize, we memoize the outputs of the sub-problems by storing them inside
 * an array. We can further optimize on space as well.
 */
public class HouseRobber {
    public int rob(int[] nums) {
        if(nums.length < 2) return nums[0];
        int n = nums.length;
        int[] dp = new int[n];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i=2; i<n; i++) {
            dp[i] = Math.max(dp[i-1], nums[i] + dp[i-2]);
        }

        return dp[n-1];
    }
}
