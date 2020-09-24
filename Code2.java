// Time Complexity : O(n)
// Space Complexity : O(n) -> Using an auxillary array ->  dp
// Did this code successfully run on Leetcode : Oms
// Any problem you faced while coding this : No, I had previously solved and understood the question.


// Your code here along with comments explaining your approach

class Solution {
    public int rob(int[] nums) {
        
        if(nums.length == 0){
            return 0;
        }
        
        if(nums.length == 1){
            return nums[0];
        }
        
        if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }

        // Checking if adding the current cost to the previous to the previous cost, yields more profit, if yes
        // set it at the current location in the dp array.
        
        int[] dp = new int[nums.length];
        
        dp[0] = nums[0];
        
        dp[1] = Math.max(nums[0], nums[1]);
        
        for(int i = 2; i < dp.length; i++){
            
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
            
        }
        
        return dp[dp.length - 1];
        
    }
}