// Time Complexity :o(n)
// Space Complexity :o(2*n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approachclass Solution {
    public int rob(int[] nums) {
        if(nums == null) return 0;
        int [][] dp = new int [nums.length][2];
        dp[0][1] = nums[0];
        for(int i  = 1; i < nums.length; i++){
            //skip
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            //take
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
            return Math.max(dp[n -1][0], dp[ n-1][1]);
    }
}