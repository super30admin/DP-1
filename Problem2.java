// Time Complexity : O(n) we loop through all numbers in nums
// Space Complexity : O(n) size of dp array. 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Problem2 {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int length = nums.length;
        int[] dp = new int[length + 1];

        //base case
        dp[length] = 0;
        dp[length - 1] = nums[nums.length - 1];

        for(int i = nums.length - 2; i >= 0; i--){
            dp[i] = Math.max(dp[i+1], dp[i+2] + nums[i]);
        }

        return dp[0];
    }
}
