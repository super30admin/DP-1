// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
/*
 * 1 - One decision making variable hence using 1-D array.
 * 2 - choose - i - 2 + curr; no choose - i - 1 so instead of using an array we can use 2 variables only
 */
public class HouseRobber {
    public int rob(int[] nums) {
        int n = nums.length;
        
        int[] dp = new int[n];
        if(n < 2)
        {
            return nums[0];
        }
        
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        
        for(int i = 2;i < nums.length;i++)
        {
            dp[i] = Math.max(dp[i-1],nums[i] + dp[i - 2]);
        }
        
        return dp[n -1];
    }
}
