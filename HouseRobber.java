/*
 *  Time Complexity: O(N) As we iterate over the array only once to calculate max sum.
 *  Space Complexity: O(N) Since we cache all the max possible sum's for each index.
 * 
 *  Did this code successfully run on Leetcode : Yes
 *  Any problem you faced while coding this : None
 * 
 *  Created a dp array of length number of house +1. Now we iterate from the last to compute the max possible sum from the last. In order to compute this value for each index we consider the maximum value between dp[index+1] and nums[index]+dp[index+2]. In the last we return the value in the index 0.
 */

class Solution {
    public int rob(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int dp[] = new int[nums.length+1];
        int len = nums.length;
        dp[len]=0;
        dp[len-1]=nums[len-1];
        for(int i=dp.length-3;i>=0;i--){
            dp[i]=Math.max(dp[i+1],(nums[i]+dp[i+2]));
        }
        return dp[0];
    }
}
