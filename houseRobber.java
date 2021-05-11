//Time complexity - O(n)
// Space complexity - O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
class Solution {
    public int rob(int[] nums) {
        
        
        int[][] dp = new int[nums.length+1][2];
        
        //for filling rows 
        
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        
        
        for(int i = 1; i < nums.length; i ++){
            
            for(int j = 0; j < 1; j ++){
                
                //case0 when not choosing
                
                
                dp[i][j] = Math.max(dp[i-1][0],dp[i-1][1]);
            //    System.out.println("case0 is" + dp[i][j]);
                
                //case1 when choosing
                                    
                dp[i][j+1] = nums[i] + dp[i-1][0];
               // System.out.println("case1 is" + dp[i][j+1]);
                
            }
        }
                                    
         return Math.max(dp[nums.length-1][0],dp[nums.length-1][1]);
    }
}