// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

public class Solution {
    public int Rob(int[] nums) {
        if(nums.Length == 0 || nums ==  null)
            return 0;
        
        if(nums.Length == 1)
            return nums[nums.Length -1];
        
        int[] dp = new int[nums.Length];
        
        dp[0] = nums[0];
        dp[1] = Math.Max(nums[0], nums[1]);
        
        for(int i = 2; i < nums.Length; i++)
        {
            dp[i] = Math.Max(nums[i] + dp[i-2], dp[i-1]);
        }
        return dp[nums.Length -1];
    }
}
