//time - O(m*n) m - dp.length, n-dp[0].length
//space - O(m*n)
class Solution {
    public int rob(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int[][] dp = new int[nums.length+1][2];

        for(int i=1; i<dp.length; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = dp[i-1][0] + nums[i-1];
        }

        return Math.max(dp[dp.length-1][0], dp[dp.length-1][1]);
    }
}