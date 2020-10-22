package S30.DP_1;


// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Converting recursive relation to bottom up DP


public class HouseRobber {

    public int rob(int[] nums) {

        if(nums == null || nums.length == 0) return 0;

        /*Objective function: F(i) = Max amount of money that can be robbed from i houses
        F(i) = Math.max(F(i-1), nums[i] + F(i-2));
        Max money till ith house = Maximum of money looted from current house + money looted till i-2 houses and money looted till i-1 house, as adjacent houses have alarm system
        */
        int[] dp = new int[nums.length + 1];
        dp[0] = 0; // 0 houses, no money can be robbed
        dp[1] = nums[0]; // 1 house, max money robbed = money present in that 1st house
        for(int i = 2; i <= nums.length; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i-1]);
        }

        return dp[nums.length];
    }
}
