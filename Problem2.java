// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
Tried greedy initially but did not work, then exhaustive which made it repeated subproblem
COnstructed 1-d dp array in which I calculaculated like below
Math.max(result till previous idx, current idx element + 2 indexes behind value)
*/


public class Problem2 {
    public int rob(int[] nums) {
        if(nums.length <= 1) {
            return nums[0];
        }

        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);

        for(int i = 2;i<nums.length;i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }

        return dp[nums.length-1];
    }
}
