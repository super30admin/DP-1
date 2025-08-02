// Time Complexity: O(n)
// Space Complexity: O(n)
// Idea is to use dynamic programming to solve sub problems.
// Each sub problem is based on one paramater - houses used for max robbery value and store this max value
// We use bottom-up approach to construct sub problems.
// Use 1d matrix to store these sub problem values and use them for next sub problem.

public class HouseRobber {
        public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);

        for(int i=2;i<nums.length;i++)
        {
            dp[i]= Math.max(dp[i-1],nums[i]+dp[i-2]);
        }
        return dp[nums.length-1];
    }
}
