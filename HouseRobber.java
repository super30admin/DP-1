/**
Time Complexity : O(n)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
*/

class Solution {
    /**
    Approach:
    - Initialize the dp array which is a 2-D matrix. Rows will be the nums.length and columns will be 2.
      Columns = 2 because there are 2 options, whether to choose to rob or not choose to rob.
    - If you choose to rob a house, add the nums[i] with the previous row's column.
    - Else, take the Math.max of previous row's values.
    */
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int m = 2;
        
        int[][] dp = new int[n][m];
        dp[0][0] = nums[0];
        dp[0][1] = 0;
        
        for(int i=1; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(j == 0) {
                    dp[i][j] = nums[i] + dp[i-1][1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][0], dp[i-1][1]);
                }
            }
        }
        return Math.max(dp[n-1][0], dp[n-1][1]);
    }
}
