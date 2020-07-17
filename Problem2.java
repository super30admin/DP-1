// Time Complexity : O(nums.length)
// Space Complexity : O(nums.length)
// Did this code successfully run on Leetcode : yes but TLE
// Any problem you faced while coding this : none

//Recursive Solution

class Solution {
    public int rob(int[] nums) {
        return helper(nums, 0, 0);
    }
    
    private int helper(int[] nums, int index, int loot){
        if(index>=nums.length)
            return loot;
        
        // if house is not robbed
        int num1 = helper(nums, index+1, loot);
        
        // if house is robbed
        int num2 = helper(nums, index+2, loot+nums[index]);
        
        return Math.max(num1, num2);
    }
}



// DP Solution
// Time Complexity : O(nums.length)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes but TLE
// Any problem you faced while coding this : none


class Solution {
    public int rob(int[] nums) {
        //base case
        if(nums==null || nums.length==0)
            return 0;
        
        int[] dp = new int[2];
        
        dp[0] = 0;
        dp[1] = nums[0];
        
        ///updating dp array
        for(int i=1; i<nums.length; i++){
            int temp = dp[0];
            dp[0] = Math.max(dp[0], dp[1]);
            dp[1] = nums[i] + temp;
        }
        
        return Math.max(dp[0], dp[1]);
    }
}


