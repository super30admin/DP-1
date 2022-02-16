public class HouseRobber {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        // return helper(nums, 0, 0);
        // int[][] dp = new int[nums.length][2];
        // dp[0][1] = nums[0];
        int skip = 0, take = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // nochoose
            int temp = skip;
            // dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            skip = Math.max(skip, take);
            // choose
            // dp[i][1] = dp[i-1][0] + nums[i];
            take = temp + nums[i];
        }
        return Math.max(skip, take);
        // return Math.max(dp[dp.length-1][0], dp[dp.length -1][1]);

    }

    // public int helper(int[] nums, int index, int maxRobbings){
    // //base
    // if(index >= nums.length) return maxRobbings;

    // //choose1
    // int case1 = helper(nums, index + 2, maxRobbings + nums[index]);
    // //choose2
    // int case2 = helper(nums, index + 1, maxRobbings);
    // return Math.max(case1, case2);
    // }
}
