//time complexity O(n)
//space complexity O(n)

class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int m = nums.length;
        int [][] dp = new int[m][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for(int i=1; i < m; i++){
            for(int j = 0; j < 2; j++){
                if(j == 0){
                    dp[i][0] = Math.max(dp[i-1][1], dp[i-1][0]);

                } else {
                    dp[i][1] = dp[i-1][0] + nums[i];

                }
            }
        }
        return Math.max(dp[m-1][0], dp[m-1][1]);
    }
}
