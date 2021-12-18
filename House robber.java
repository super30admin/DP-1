// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int rob(int[] nums) {
    //     int result = maxMoney(nums, 0);
    //     return result;
    // }
    // private int maxMoney(int[] nums, int index){
    //     if(index >= nums.length){
    //         return 0;
    //     }
    //     int taken = nums[index] + maxMoney(nums, index+2);
    //     int notTaken = maxMoney(nums, index+1);
    //     return Math.max(taken, notTaken);
        
        int[][] dp = new int[nums.length+1][3];
        for(int i = 0; i < 2; i++){
            dp[0][i] = 0;
        }
        
        for(int i = 1; i <= nums.length; i++){
            dp[i][0] = dp[i-1][1] + nums[i-1];
            dp[i][1] = Math.max(dp[i-1][0], dp[i-1][1]);
        }
        return Math.max(dp[nums.length][0],dp[nums.length][1]);
    }
}