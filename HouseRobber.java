// Time Complexity: O(n)
// Space Complexity: O(n)

public class HouseRobber {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        // if the input length is 1
        int n = nums.length;
        if(n < 2) return nums[0];

        int[] dp = new int[n];

        dp[0] = nums[0];
        // Take the max of 1st house and 2nd house to get the max amount for first two houses
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i=2; i<nums.length; i++){
            // The amount robbed until ith house will be max between the amount robbed by considering the ith house and not considering the the ith house
            // i-1 for getting not considering the ith house
            // nums[i] + dp[i-2] for getting the amount stole by considering current house, i-2 for avoiding adjacent houses
            dp[i] = Math.max(dp[i-1], nums[i] + dp[i-2]);
        }
        return dp[n-1];
    }
}
