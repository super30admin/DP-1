// Problem 2: House Robber
class Problem2_2DArray {
    public int rob(int[] nums) {
      if(nums== null ||nums.length ==0) return 0;
      
        int [][] dp = new int[nums.length][2];
        dp[0][1]= nums[0];
        
        for(int i=1; i<nums.length; i++){
            
            dp[i][0]= Math.max(dp[i-1][0],dp[i-1][1]);
            dp[i][1]= dp[i-1][0]+nums[i];
            
        }
        
        return Math.max(dp[nums.length-1][0], dp[nums.length-1][1]);
    }
}

/*
Time Complexity : O(n)
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
Approach:
- We identified repeated sub-problem in brute force method and want to implement it using
DP method
- The repeated sub problem is: at each home we try to maximize the amount considering 
choose and not choose cases. The result from the previous computation is used to compute
result for the next one.
- Create a 2-d DP array of size NX2
- Fill the 0 th column with values considering the house not chosen case
- Fill the 1st column with the values considering the house is chosen.
- Return the maximum of the 2 columns from the last row of the 2 D array

*/