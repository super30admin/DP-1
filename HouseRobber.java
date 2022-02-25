// Time Complexity : O(n) where n is size of array
// Space Complexity : O(1) as we are storing base cases in dp array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int rob(int[] nums) {
        
        int n = nums.length;
        
        int[] dp = new int [n];
        
        dp[0] = nums[0];
        
        if (n == 1) {
            return dp[0];
        }
        
        dp[1] = Math.max(nums[0], nums[1]);
        
        // iterating from 0 to ith element
        // can also do from ith to n 
        for (int i = 2; i < n; i++) {
            
            dp[i] = Math.max(
                nums[i] + dp[i-2], //robbing
                dp[i-1] // not robbing
            );
        }
        return dp[n-1];
    }
}
