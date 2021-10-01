// Time Complexity :o(n)
// Space Complexity :o(m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :




class Solution {
    public int rob(int[] nums) {
        if(nums.length==0) return 0;
        int m=nums.length;
        int[][] dp= new int[m][2];
        dp[0][0]=nums[0];
        dp[0][1]=0;
        
        for(int i=1; i<m; i++){
            dp[i][0]=nums[i]+dp[i-1][1];
            dp[i][1]= Math.max(dp[i-1][0], dp[i-1][1]);
        }
        
        return Math.max(dp[m-1][0], dp[m-1][1]);
        
    }
}