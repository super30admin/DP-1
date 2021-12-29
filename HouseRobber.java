

// Time Complexity : Add : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = {2,1,1,2};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        if(nums.length == 1)
            return nums[0];

        if(nums.length == 2)
            return Math.max(nums[0], nums[1]);

        int[] dp = new int[nums.length];   // S.C - O(N)
        dp[0] = nums[0];
        // Maintain the maximum value
        dp[1] = Math.max(nums[0], nums[1]);


        for(int i=2; i<nums.length; i++){    // T.C - O(N)
            dp[i] = Math.max(dp[i-1], nums[i]+dp[i-2]);
        }

        return dp[dp.length-1];
    }
}
