// Time Complexity : O(N) Where N is length of nums array
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length==0) return 0;
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        if (n==1) return nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        
        for(int i=2;i<n;i++){
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]); //there are two cases when we choose to rob a house or not. We compare output in both cases and choose which gives maximum amount
        }
        return dp[n-1];
   
    }
}

