// Time Complexity : o(n)
// Space Complexity : o(1)
public class Problem2 {
    public int rob(int[] nums) {

        //DP Bottom Up
        // int[][] dp = new int[nums.length][2];
        // dp[0][1]=nums[0];
        // for(int i=1; i<nums.length;i++){
        //     dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]);
        //     dp[i][1]=dp[i-1][0]+nums[i];
        // }
        // return Math.max(dp[nums.length-1][0],dp[nums.length-1][1]);
        
        //DP Optimization
        int skip=0;
        int take=nums[0];
           for(int i=1; i<nums.length;i++){
              int tempSkip=skip;
              skip=Math.max(skip,take);
              take=tempSkip+nums[i];
        }
        
        return Math.max(skip,take);
    }
}
