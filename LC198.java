class Solution {
    public int rob(int[] nums) {
        
        int m = nums.length;
        //int n = 2;
        
        int dp[][] = new int[m][2];
        
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        
        for(int i=1;i<dp.length;i++)
        {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]);
            
            dp[i][1] = dp[i-1][0] + nums[i];
        }
        
        return Math.max(dp[m-1][0],dp[m-1][1]);
    }
}