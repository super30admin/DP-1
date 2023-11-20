// Time Complexity : O(n)
// Space Complexity : for rob1 o(n) and for rob2 o(1)
// Did this code successfully run on Leetcode : yes
//## Problem2 (https://leetcode.com/problems/house-robber/)
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
public class HouseRobber {
    public int rob(int[] nums) {
        return helper(nums,0,0);

    }
    private int helper(int[] nums, int i, int cost){
        //base
        if(i >= nums.length)
            return cost;

        //logic
        int case0 = helper(nums, i+1, cost);

        int case1 = helper(nums, i+2, cost+nums[i]);

        return Math.max(case0, case1);
    }
    public int rob1(int[] nums) {
        if(nums==null || nums.length == 0 ) return 0;
        if(nums.length == 1) return nums[0];

        int dp[] = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i = 2; i < nums.length; i++){
            dp[i] = Math.max(dp[i-1], nums[i]+dp[i-2]);
        }
        return dp[nums.length-1];
    }
    public int rob2(int[] nums) {
        if(nums==null || nums.length == 0 ) return 0;
        if(nums.length == 1) return nums[0];

        // int dp[] = new int[nums.length];

        int prev = nums[0];
        int curr = Math.max(nums[0],nums[1]);
        for(int i = 2; i < nums.length; i++){
            int temp = curr;
            curr = Math.max(curr, nums[i]+prev);
            prev = temp;
        }
        return curr;
    }
}
