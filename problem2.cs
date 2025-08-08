public class Solution {
    public int Rob(int[] nums) {
        var length = nums.Length;
        int[] dp = new int[length];
        dp[0]=nums[0];
        for(var i=1;i<length;i++)
        {
            var temp = i-2>=0?dp[i-2]:0;
            dp[i] = Math.Max(dp[i-1],nums[i]+temp);
        }
        return dp[length-1];
    }
}