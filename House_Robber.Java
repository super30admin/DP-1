House robber
class Solution {
    int[] dp;
    public int rob(int[] nums) {
        dp=new int[nums.length+2];
        for(int i=nums.length-1;i>=0;--i){
            dp[i]=Math.max(nums[i]+dp[i+2],dp[i+1]);
            
        }
        return dp[0];
    }
}
