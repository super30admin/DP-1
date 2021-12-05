// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// This approach uses only 2 variables instead of a 2D array, which is a space optimization
class Solution {
    public int rob(int[] nums) {
        if (nums==null || nums.length==0) return 0;

        //Initially will have (0,nums[0]) values for skipped and robbed fields
        int skipped = 0, robbed = nums[0];

        for (int i=1; i<nums.length; i++) {
            int previous_skipped = skipped;
            //If robber skips the house, he will have the max between the previous two decisions
            skipped = Math.max(skipped, robbed);
            //If robber robs the house he will have current loot + the previous skipped loot
            robbed = nums[i]+previous_skipped;
        }

        //The final loot will be the max between skipped and robber values
        return Math.max(skipped, robbed);
    }
}

/*
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
 class Solution {
     public int rob(int[] nums) {
         if (nums==null || nums.length==0) return 0;

         int[][] dp = new int[nums.length][2];
         //First row will have (0,nums[0]) values for skipped and robbed fields
         dp[0][1] = nums[0];

         for (int i=1; i<nums.length; i++) {
             //If robber skips the house, he will have the max between the previous two decisions
             dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
             //If robber robs the house he will have current loot + the previous skipped loot
             dp[i][1] = nums[i]+dp[i-1][0];
         }
         //The final loot will be the max between skipped and robber values of the last row
         return Math.max(dp[nums.length-1][0], dp[nums.length-1][1]);
     }
 }
 */