//Problem - HouseRobber
// Time Complexity : O(n), n represents number of houses
// Space Complexity : O(1), did with two variables that are skip & take
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**  Steps
 * 1) --> Using Auxilary DP Matrix-> TC: O(n), SC:O(n) 
        *  1) Create a dp matrix containing rows as house values and columns as 0 & 1 which means choose the house value or not.
        *  2) Initialise 1st row and 2nd column with house value.
        *  3) Further on each traversal choose max of above row values for filling the 0(not choose) column and for the 1st columns add current house value and previous row value of not choosing house.  
 * 2) Using Two variables, as we need only two values, then instead of creating auxilary dp matrix use skip and take variable. TC-O(n),SC-O(1)
 * 
*/


class Solution21DpBottomUp {
    
    public int rob(int[] nums) {
     
        if(nums==null || nums.length==0){
            return 0;
        }
        
        /*//TC-O(n), SC-O(n)
        int[][] dp = new int[nums.length][2];
        dp[0][1] = nums[0];
        
        
        for(int i=1;i<dp.length;i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]);
            dp[i][1] = dp[i-1][0]+nums[i];
        }
        
        return Math.max(dp[nums.length-1][0],dp[nums.length-1][1]);
        */
        
        //As we need only two values, use two variables//TC-O(n), SC-O(1)
        int skip = 0;
        int take = nums[0];
        
        for(int i=1;i<nums.length;i++){
            int temp = skip;
            
            skip = Math.max(skip,take);
            take = temp+nums[i];
            
        }
        
        return Math.max(skip,take);
        
    }
    
}