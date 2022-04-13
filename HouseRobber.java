// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class HouseRobber {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        
        if(nums.length == 1) {
            return nums[0];
        }
        
        int[] dp = new int[nums.length];
        int maxProfit = Integer.MIN_VALUE;
        
        dp[dp.length-1] = nums[nums.length - 1];
        dp[dp.length-2] = nums[nums.length - 2];

        
        for(int i = nums.length - 3 ; i >= 0; i--) {
            int max = Integer.MIN_VALUE;
            for(int j = i + 2; j < nums.length; j++) {
                max = Math.max(max, dp[j]);
            }
            dp[i] = nums[i] + max;

        }
        
        for(int i = 0; i < dp.length; i++) {
            maxProfit = Math.max(maxProfit, dp[i]);
        }
        return maxProfit;
    }
}