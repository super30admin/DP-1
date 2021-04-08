/*
  
  Thought Process: Understanding it is a DP problem, then creating the graph for selection process and devleoping logic there on white board
  TC -> O(N*2) = O(N)
  SC -> O(N*2) = O(N)
  where N = nums length
  
  Mistakes commited ? None
    
*/

class HouseRobber {
    public int rob(int[] nums) {
        
        int[][] dp = new int[nums.length][2];
        
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        
        for(int i=1; i<dp.length; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = dp[i-1][0] + nums[i];
        }
        return Math.max(dp[dp.length-1][0], dp[dp.length-1][1]);
    }
}