// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * We have two cases, choose current hourse or not choose current house.
 * So for each row which represents houses, we caluclate both cases.
 * If we decided not to choose current house, then max amount till this house will be maximum in previous interation
 * Else if we decided to choose current house, we cannot choose previous so max amount will be current house amount + previous case amount without choose previous house
 * In last row, we take maximum of both cases.
*/

class Solution {
    public int rob(int[] nums) {
        int[][] dp = new int[nums.length+1][2];
        dp[0][0] = 0;
        dp[0][1] = 0;
        
        for(int r = 1; r < dp.length;r++){
            dp[r][0] = Math.max(dp[r-1][0] , dp[r-1][1]);
            dp[r][1] = dp[r-1][0] + nums[r-1];
        }
        
        return Math.max(dp[dp.length-1][0], dp[dp.length-1][1]);
        
   //     return cal(nums, 0, 0);
        
    }
    
    //Recursive approach solution

    private int cal(int[] nums, int index, int amount){
        //base case
        if(index >= nums.length)return amount;
        
        //logic
        int case1 = cal(nums, index + 2, amount + nums[index]); //choose current house
        
        int case2 = cal(nums, index + 1, amount );  //not to choose current house
        
        return Math.max(case1, case2);   //return maximum of both cases
    }
}