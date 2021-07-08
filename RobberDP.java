// Time Complexity : O(n) going over the array
// Space Complexity : O(n) auxilary array to keep a track max money got till now
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Finding the pattern here
/* Your code here along with comments explaining your approach: As we go over the array, we create a aux array called dp[].
dp stores the max money we have got till ith position. We calculate the next maximum we can get as we move to the next step and store 
the max we got in the next index. The last index will spit out the solution. */
class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        if(nums == null || nums.length == 0){return 0;}         // Base case
        if(nums.length==1){return nums[0];}             // If only one house, that will be robbed
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);         // Start with the max
        for(int i = 2; i < nums.length;i++){
            dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);                 // See if you can get max by starting from 0 and stealing the current house and money stolen till now or the previous house has more money
        }
        return dp[nums.length-1];                   // return the last value as the result as it sums up the total money gained
    }
}