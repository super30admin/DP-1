// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
// I used a DP array where each index stores the maximum money that can be robbed up to that house.
// For every house, I choose the best option between skipping it or robbing it plus the value from two houses before.
// Finally, I return the last DP value, which represents the maximum amount that can be robbed without triggering the alarm.

class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,0);
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0],nums[1]);
        for (int i =2; i < n; i++){
            dp[i] = Math.max(dp[i-1], nums[i]+ dp[i-2]);
        }
        return dp[n-1];
    }
}