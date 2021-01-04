//Problem - HouseRobber
// Time Complexity : O(n), n represents number of houses
// Space Complexity : O(n), n represents number of houses
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**  Steps 
 *  Implemented using Recursion with DP. Whenever I'm calculating max amount for a house, I'm storing it in 1d array. If 1d array is not empty for a specific house, then I'm just returning the value stored for that house, so that its preventing recalculation of sub problems and thus it is O(n); 
 * 
 * 
*/


class Solution21DpTopDown {
    
    Integer[] dp;
    public int rob(int[] nums) {
     
        if(nums==null || nums.length==0){
            return 0;
        }
        
        dp = new Integer[nums.length];
        
        return calcMax(nums,nums.length-1);
    }
    
    private int calcMax(int[] nums, int n){
        
        //base
        if(n<0){
            return 0;
        }
        
        if(dp[n]!=null){
            return dp[n];
        }
        
        //logic
        return dp[n] = Math.max(nums[n]+calcMax(nums,n-2),calcMax(nums,n-1));
        
    }
    
}