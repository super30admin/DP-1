// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class Solution {
    public int rob(int[] nums) {
        
        int n = nums.length;
        int dp[] = new int[n];
        dp[0] = nums[0];

        if(n == 1)
            return dp[0];

        //we will build a dp tree of choose and not choose. Store the max
        //case 1: Choose : nums[i] + dp[i - 1]
        //case 2 : Not choose : dp[i - 1]

        dp[1] = Math.max(nums[1] + 0, dp[0]);

        for(int i = 2; i < n; i++) {
            
            //we should avoid neighbors if chosen
            int case1 = nums[i] + dp[i - 2];

            //if not chosen then get neighbors
            int case2 = dp[i - 1];

            dp[i] = Math.max(case1, case2);
        }

        return dp[n - 1];
    }
}