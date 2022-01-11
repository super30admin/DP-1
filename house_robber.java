// Time complexity : O(n)
// Space Complexity : O(n*2)

class Solution {
    public int rob(int[] nums) {
        
        // 2d array of taken and not taken
        int[][] dp =  new int[nums.length + 1][2];
        
        // Initialise first row
        dp[0][0] = 0;
        dp[0][1] = 0;
            
        int notTaken = 0;
        int taken =0;
        int maxVal = Integer.MIN_VALUE;
        
        for (int row = 1; row <= nums.length ; row++){
            
            // Not taken case :consider the max value from the previous row
            notTaken = Math.max(dp[row - 1][0] , dp[row - 1][1]);
            
            // Taken case : Prvious value not taken case +  present value taken
            taken = dp[row-1][0] + nums[row - 1];
            
            maxVal =  Math.max(maxVal, Math.max(notTaken, taken));
            
            //Store the values in dp
            dp[row][0] = notTaken;
            dp[row][1] = taken;
        }
        
        return maxVal;
    }
}