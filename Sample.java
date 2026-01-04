// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// https://leetcode.com/problems/coin-change/description/
// Time Complexity : O(m*n) where m is number of coins and n is amount
// Space complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length+1][amount+1];
        int re = helper(coins,0,amount,dp);
        if(re==99999) return -1;
        return re;
    }
    int helper(int[] coins,int idx,int amount,int[][] dp){
        // base
        if(amount==0) return 0;
        if(amount<0) return 99999;
        if(idx==coins.length){
            return 99999;
        }
        if(dp[idx][amount]!=0) return dp[idx][amount];
        // logic
        // pick the current idx value
       int case2 = helper(coins,idx+1,amount,dp);
       int case1 = 1+helper(coins,idx,amount-coins[idx],dp);

       // not pick the current idx value
       dp[idx][amount] =  Math.min(case1,case2);
       return Math.min(case1,case2);
    }
}
// https://leetcode.com/problems/house-robber/description/
//  Time Complexity : O(n) where n is number of houses
// Space complexity : O(n)
// Did this code successfully run on Leetcode : yes
class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return helper(nums,0,dp);
    }
    int helper(int[] nums,int idx,int[] dp){
        // base case
        if(idx>=nums.length) return 0;
        if(dp[idx]!=-1) return dp[idx];
        // logic
        // pick house at index idx 
        int case1 = nums[idx]+helper(nums,idx+2,dp);
        // dont pick the house at index idx
        int case2 = helper(nums,idx+1,dp);
        dp[idx] = Math.max(case1,case2);
        return Math.max(case1,case2);
    }
}
//  Time Complexity : O(n) where n is number of houses
// Space complexity : O(n)
// Did this code successfully run on Leetcode : yes
class Solution {
    public int rob(int[] nums) {
       if(nums.length==1) return nums[0]; 
       int prev = nums[0];
       int curr = Math.max(nums[0],nums[1]);
       for(int i=2;i<nums.length;++i){
          int temp = curr;
          curr = Math.max(curr,nums[i]+prev);
          prev = temp;
       }
       return curr;
    }
}