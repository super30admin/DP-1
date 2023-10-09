// Time Complexity : O(N) where N is number of houses
// Space Complexity : O(N) wwhere N is number of houses
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class HouseRobber
{
    class Solution {
        public int robDP(int[] nums) {

            int[] dp = new int[nums.length+2];
            for(int i = 2; i< dp.length; i++)
            {
                dp[i] = Math.max(nums[i-2] + dp[i-2], dp[i-1]);
            }
            return dp[dp.length-1];
        }

        public int rob(int[] nums) {
            if(nums.length == 1)
                return nums[0];
            if(nums.length == 2)
                return (nums[0] >= nums[1] ? nums[0] : nums[1]);

            return helper(nums, 0, 0);
        }

        public int helper(int[] nums, int idx, int profit)
        {
            // base
            if(idx >= nums.length)
                return profit;

            int chooseHouse = helper(nums, idx+2, profit+nums[idx]);
            int notChooseHouse = helper(nums, idx+1, profit);

            return Math.max(chooseHouse, notChooseHouse);
        }
    }
}
