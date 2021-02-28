class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int n = nums.length, m=2;
        int[][] dp = new int[n][m];
        
        dp[0][0] = nums[0];
        dp[0][1] = 0;
        for(int i=1; i<n; i++){
            dp[i][0] = nums[i] + dp[i-1][1];
            dp[i][1] = Math.max(dp[i-1][0], dp[i-1][1]);
        }
        return Math.max(dp[n-1][0], dp[n-1][1]);
    }
}
//time - O(N)
//space - O(N)