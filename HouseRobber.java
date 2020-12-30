
public class HouseRobber {
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Getting started and trying to understand DP


// Your code here along with comments explaining your approach

    class Solution1 {
        public int rob(int[] nums) {
            //Return 0 if no value in array or array null
            if(nums.length == 0 || nums == null) return 0;

            //Create dp array and initialize it
            int[] dp = new int[nums.length + 1];

            //set first 2 starting values in dp array
            dp[0] = 0;
            dp[1] = nums[0];

            //se dp[i + 1] to the max value of either the current dp array or num[i] + 2 arrays before it
            for(int i = 1; i<nums.length; i++){
                dp[i+1] = Math.max(nums[i] + dp[i-1], dp[i]);
            }

            //return max value from dp array
            return dp[nums.length];
        }
    }

}
