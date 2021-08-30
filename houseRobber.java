public class houseRobber {
    // variable method
    public int houseRobber(int[] nums){
        if(nums == null || nums.length == 0) return 0;
        int skip  = 0;
        int take = nums[0];
        for(int i=1; i<nums.length; i++){
            int temp = skip;
            //not choose
            skip = Math.max(skip, take);
            //choose
            take = temp + nums[i];
        }
        return Math.max(skip, take);
    }

    //dp matrix method
    public int houseRobber1(int[] nums){
        if(nums == null || nums.length == 0) return 0;
        int dp[][] = new int[nums.length][2];
        dp[0][1] = nums[0];
        for(int i=1; i<nums.length; i++){
            //not choose
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            //choose
            dp[i][1] = dp[i-1][0] + nums[i];
        }
        return Math.max(dp[dp.length-1][0], dp[dp.length-1][1]);
    }
}
