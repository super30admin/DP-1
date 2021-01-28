// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : figuring out the logic to construct the dp array

public class HouseRobber {
    public int rob(int[] nums) {
        
        // If nums is empty, return 0
        if(nums.length == 0) {
            return 0;
        }
        
        // 1st coulmn represnts including the house, 2nd column represents not including the house
        int dp[][] = new int[nums.length][2];
        
        dp[0][0] = nums[0];
        dp[0][1] = 0;
        
        for(int i=1; i< nums.length; i++) {

            // If (cost of current house + cost of not including the previous house) is greater than cost of including the previous house, include the current house, else do not
            if((nums[i] + dp[i-1][1]) > dp[i-1][0]) {
                dp[i][0] = nums[i] + dp[i-1][1];
            } else {
                 dp[i][0] = dp[i-1][0];
            }
            
            // set the cost of not including the current house as the cost of including the previous house
            dp[i][1] = dp[i-1][0];
        }
        
        if(dp[nums.length-1][0] > dp[nums.length-1][1]) {
            return dp[nums.length-1][0];
        } else {
            return dp[nums.length-1][1];
        }
    }
}