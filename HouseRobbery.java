// Time Complexity : O(n) where n = length of the array
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int[] dp = new int[nums.length+1];
        dp[0] = 0;
        dp[1] = nums[0];
        int max = 0;
        for(int i = 2; i<nums.length+1; i++) {
            if(dp[i-1]<dp[i-2]+nums[i-1]){
                dp[i] = dp[i-2]+nums[i-1];
            } else {
                dp[i] = dp[i-1];
            }
        }
        return dp[dp.length-1];
    }
}

// Time Complexity : O(n) where n = length of the array
// Space Complexity : O(1) as we are using only variables skip and take
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int skip = 0;
        int take = 0;
        int temp = 0;

        for(int i = 0; i<nums.length; i++){
            temp = skip;
            skip = Math.max(skip, take);
            take = temp+nums[i];
        }

        return Math.max(skip, take);
    }
}