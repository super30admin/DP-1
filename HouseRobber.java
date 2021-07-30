//https://leetcode.com/problems/house-robber/
/*
Time: O(n)
Space: O(n) for dp array
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/

public class HouseRobber {

    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        if (n == 0)
            return 0;

        if (n >= 1)
            dp[0] = nums[0];

        if (n >= 2)
            dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++)
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);

        return dp[n - 1];

    }
}
