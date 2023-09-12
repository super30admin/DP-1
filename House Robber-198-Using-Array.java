class Solution {
  // Time Complexity: O(n)
  // Using dp array

    public int rob(int[] nums) {
        if(nums == null || nums.length == 0)
        {
            return 0;
        }
        // Rows is the number of elements in nums array and we have 2 columns 
        // 0 or 1 where we store sum if we do not consider its corresponding value  amd 1 where we store sum if we consider the corresponding value.
        int[][] dp = new int[nums.length][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for(int i=1;i<dp.length;i++)
        {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = nums[i] + dp[i-1][0];
        }
// Return max value
        return Math.max(dp[nums.length-1][0], dp[nums.length-1][1]);
        
    }

    
}
