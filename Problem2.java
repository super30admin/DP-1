public class Problem2 {
    public int rob(int[] nums) {
        int n= nums.length;
        int[] dp= new int[n+1];
        dp[0]=nums[0];
        if(nums.length<=1){
            return dp[0];
        }
        else
        {
            dp[1]= Math.max(dp[0],nums[1]);
        }
        for(int j=2;j<n;j++){
            dp[j]=Math.max(dp[j-1],nums[j]+dp[j-2]);
        }
        return dp[n-1];
    }
}