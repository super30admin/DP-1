
// Time Complexity : O(n), n = number of houses
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

// Approach:
// 1. I used Dynamic Programming to find out the maximum amount that can be robbed.
// 2. Initialized the DP matrix' first row, with 0, so that next rows (including first row) can be compared with the earlier rows.
// 3. On every iteration, I consider the two cases, whether I rob the house, or I don't rob the house. If I don't rob the house, I take the maximum amount robbed
// from the last row. If I rob the house, I take the amount robbed from this house + the amount robbed from last row without robbing it's just previously visited 
// neighbor.
// 4. Maximum element from the last row of the DP matrix gives me the maximum amount that can be robbed.

class Solution {
    public int rob(int[] nums) {
        int[][] dp = new int[nums.length+1][2];
        dp[0][0] = 0;
        dp[0][1] = 0;
        
        for(int i = 1; i < nums.length + 1; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = nums[i-1]+dp[i-1][0];
        }
        
        return Math.max(dp[nums.length][0], dp[nums.length][1]);
    }
}


class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int prev_0 = 0;
        int prev_1 = nums[0];
        int maxAmount = prev_1;
        for(int i = 1; i < nums.length; i++){
            int temp = prev_0;
            prev_0 = prev_1;
            prev_1 = Math.max(temp+nums[i], prev_1);
        }
        return prev_1;
    }    
}
