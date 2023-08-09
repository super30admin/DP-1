public class houseRobber {

    public static int rob(int[] nums){
        if(nums == null || nums.length == 0) return 0;
        int skip = 0; int take = nums[0];
        int prevSkip = 0;
        // int [][]dp = new int[nums.length][2];
        // dp[0][1] = nums[0];
        for(int i = 1; i < nums.length; i++){
            prevSkip = skip;
            // not rob
            // dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            skip = Math.max(prevSkip, take);
            // to rob
            // dp[i][1] = dp[i-1][0] + nums[i];
            take = prevSkip + nums[i];
        }
        // return Math.max(dp[dp.length - 1][0], dp[dp.length - 1][1]);
        return Math.max(skip, take);

    }

    public static void main(String[] args){
        int[] nums = {2, 7, 9, 8, 1, 1, 5};
        int result = rob(nums);

    }
    
}
