// Time Complexity : O(n)
// Space Complexity : O(n), where n is the number of houses along a street.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int rob(int[] nums) {
        if(nums==0||nums.length==0)
            return 0;
        int [] dp = new int[nums.length+1];
	// if there is no house then maximum amount = 0
	//if there is only 1 house then maximum amount = price of robbing that only house i.e. nums[0].
        dp[1] = nums[0];
        for(int i =2;i<nums.length+1;i++){
            dp[i] = Math.max(nums[i-1]+dp[i-2],dp[i-1]);
        }
        return dp[nums.length];
    }
}