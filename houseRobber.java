// Time Complexity : O(n)
// Space Complexity : Solution 1: O(n), Solution 2: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    /****        SOLUTION 1       ******/
    //     public int rob(int[] nums) {
    //         int maxRobbings = 0;
    //         if(nums.length == 0){
    //             return maxRobbings;
    //         }
            
    //         int[][] dp = new int[nums.length][2];
    //         dp[0][0] = 0;
    //         dp[0][1] = nums[0];
    //         for(int i = 1; i < dp.length; i++){
    //             dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
    //             dp[i][1] = dp[i-1][0] + nums[i];
    //         }
            
    //         return Math.max(dp[nums.length - 1][1], dp[nums.length-1][0]);
    //     }
        
        
    /****        SOLUTION 2       ******/
        public int rob(int[] nums) {
            int maxRobbings = 0;
            if(nums.length == 0){
                return maxRobbings;
            }
            int choose = 0;
            int notChoose = 0;
            
            for(int i = 0; i < nums.length; i++){
                int tempNotChoose = notChoose;
                notChoose = Math.max(notChoose, choose);
                choose = tempNotChoose + nums[i];
            }
            
            return Math.max(choose, notChoose);
        }
        
    }