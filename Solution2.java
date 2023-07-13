class Solution2 {
    public int rob(int[] nums) {
        int m=nums.length;
        int[] dp=new int[m];
        dp[0]=nums[0];
        if(nums.length<2)
        {
            return dp[0];
        }
        dp[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<m;i++)
        {
            dp[i]=Math.max(dp[i-1],nums[i]+dp[i-2]);
        }

        return dp[m-1];
    }
}