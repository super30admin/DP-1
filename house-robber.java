// Time Complexity : n (DP) where, n=number of houses
// Space Complexity : n
// Did this code successfully run on Leetcode :  NO; 50% cases passed
// Any problem you faced while coding this : COuld not get to final solution

// refered to lecture

// Your code here along with comments explaining your approach

class Solution {
    public int rob(int[] nums) {
        // edge cases
        if(nums.length == 0){
            return 0;
        }
        
        if(nums.length == 1){
            return nums[0];
        }
        
        if(nums.length <3){
            return Math.max(nums[0], nums[1]);
        }

        //1D array
        int dp[] = new int[nums.length];
        
        dp[0]=nums[0];
        dp[1]=nums[1];
        // fill values in array checking with i-1 index
        int max_num = Math.max(dp[0],dp[1]);
        for(int i=2; i< nums.length; i++){
            
            dp[i] = (nums[i]+dp[i-2]);
            max_num = Math.max(max_num, dp[i]); 
            
        }
        
        return max_num;
    }
}