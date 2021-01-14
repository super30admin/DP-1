Time Complexity-O(n)
Space Complexity-O(n)

class Solution {
    public int rob(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        int m=nums.length;
        int n=3;
        int[][] dp=new int[m][n];
        for(int i=0;i<nums.length;i++)
        {
            dp[i][0]=nums[i];
        }
        dp[0][1]=nums[0];
        dp[0][2]=0;
        for(int i=1;i<m;i++)
        {
                  dp[i][1]=dp[i][0]+dp[i-1][2];
                  dp[i][2]=Math.max(dp[i-1][1],dp[i-1][2]);
        
        }
        return Math.max(dp[m-1][1],dp[m-1][2]);
    }
}
