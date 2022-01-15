//HouseRobber Dynamic Programing
//https://leetcode.com/submissions/detail/616698163/
//Time: O(n)
//Space: O(1)

class Solution {
    public int rob(int[] nums) {
        int[][] dp = new int[nums.length + 1][2];
        
        dp[0][0] = 0;
        dp[0][1] = 0;
        
        int max = Integer.MIN_VALUE;
        
        for(int i = 1; i <= nums.length; i++){
            
            int notTaken = Math.max(dp[i - 1][0], dp[i - 1][1]);
            int taken = dp[i - 1][0] + nums[i - 1];
           
            max = Math.max(max, Math.max(taken, notTaken));
            dp[i][0] = notTaken;
            dp[i][1] = taken;
        }
        
        return max;
    }
}
