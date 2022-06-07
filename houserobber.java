// Time Complexity : O(n) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length <2) return nums[0];
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i =2; i <nums.length; i++){
            dp[i] = Math.max(dp[i-1], nums[i] + dp [i-2]);
        }
        return dp[n-1];
    }
    
  
}

/*Recursive solution
class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        return helper(nums,0,0);
    }
    private int helper(int[] nums, int i, int amount){
        //base
        if( i >= nums.length) return amount;
        //logic to choose
        int case1 = helper(nums, i+2, amount+nums[i]);
        //no choose
        int case2 = helper(nums,i+1, amount);
        return Math.max(case1,case2);
    }
}
*/