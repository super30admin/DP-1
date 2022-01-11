// Time complexity : O(n)
// Space Complexity : O(1)

class Solution {
    public int rob(int[] nums) {
            
        int notTaken = 0;
        int taken =0;
        int maxVal = Integer.MIN_VALUE;
        
        for (int row = 0; row < nums.length ; row++){
            
            // Store the max value from the previous row in  temp
            int temp = notTaken;

            // Not taken case
            notTaken = Math.max(notTaken, taken);
            
            // Taken case : Prvious value not taken case +  present value taken
            taken = temp + nums[row];
            
            maxVal =  Math.max(maxVal, Math.max(notTaken, taken));
            
        }
        
        return maxVal;
    }
}