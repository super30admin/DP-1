class Solutions {

    int maxMoney =0;
    public int rob(int[] nums) {

        int dp[] = new int[nums.length+1];

        dp[0]=0; // robbing 0 houses we get 0 money
        dp[1]=nums[0];// first element as we rob first house

        for(int i=1;i<nums.length;i++)
        {
            dp[i+1]= Math.max(dp[i-1]+nums[i],dp[i]); // dp[i+1] is next element which will have dp[i-1] previous element plus the current sum maintaining no adjancency. or the previous lement -> maximum of any two
        }


        return dp[nums.length];
    }


}