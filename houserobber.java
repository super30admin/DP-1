// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

class Solution {
    public int rob(int[] nums) {
        //edge
        if(nums == null || nums.length == 0)
            return 0;
         
        
        
        int skip = 0;
        int take = nums[0];
        for(int i=1; i<nums.length; i++){
            int temp = skip;
            skip = Math.max(skip, take);
            take = temp + nums[i];
        }
        return Math.max(skip, take);
    }
    
}


/*
using n*2 array
class Solution {
    public int rob(int[] nums) {
        //edge
        if(nums == null || nums.length == 0)
            return 0;
         
        int[][] dp = new int[nums.length][2];
        
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for(int i=1; i<dp.length; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = dp[i-1][0]+ nums[i];
        }
        return Math.max(dp[nums.length -1][0], dp[nums.length -1][1]);
    }
    
}
*/

/* Brute Force Solution
class Solution {
    public int rob(int[] nums) {
        //edge
        if(nums == null || nums.length == 0)
            return 0;
        return helper(nums, 0, 0);
    }
    
    public int helper(int[] nums, int index, int amount){
        //base
        if(index >= nums.length) 
            return amount;
        //logic
        //choose case
        int case1 = helper(nums, index+2, amount+nums[index]);
        //no choose case
        int case2 = helper(nums, index+1, amount);
        return Math.max(case1, case2);
        
    }
}
*/