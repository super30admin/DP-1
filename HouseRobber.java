public class HouseRobber {
    public static int rob(int[] nums) {
        int[] dp = new int[nums.length+1];
        dp[0] = 0;
        dp[1] = dp[0] + nums[0];
        for(int i=2;i<nums.length+1;i++){
            // max(not choose current,choose current)
            dp[i] = Math.max(dp[i-1],nums[i-1]+dp[i-2]);
        }
        return dp[nums.length];

    }

    public static void main(String[] args) {
        System.out.println(HouseRobber.rob(new int[] {2,7,9,3,1}));
    }
}
