//Time complexity: O(n)
//Space complexity: O(n) -- using dp
//DP approach

class Solution {
    public int rob(int[] nums) {
        if(nums == null) return 0;
        int n = nums.length;
        int[][] dp = new int[nums.length][2];
        dp[0][1] =  nums[0];
        for(int i=1; i< nums.length; i++){
            //skip
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            
            //take
            dp[i][1] = nums[i] + dp[i-1][0];
        }
        
        return Math.max(dp[n-1][0], dp[n-1][1]);
        
    }
}