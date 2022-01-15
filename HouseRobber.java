// DP Approach
// Form a matrix to store possible values from the choose given house to corresponding value or not
// Check for max between the row just above it between max from choose not choose
// Fill the matrix and the last value will give you the max profit from the robbery

// Time Complexity O(n)
// Space Complexity O(n)

class Solution {
    public int rob(int[] nums) {
        int[][] dp = new int[nums.length][2];
        dp[0][1] = nums[0];
        for(int i=1;i<nums.length;i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = dp[i-1][0]+nums[i];
        }
        return Math.max(dp[nums.length-1][0],dp[nums.length-1][1]);
    }
}