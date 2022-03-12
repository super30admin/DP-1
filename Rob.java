public class Rob {
  /**
   * Any Problems solving this? No
   * Were you able to solve it on leetcode? Yes
   */
  
  /**
  Approach - 1 
  Maintain a DP matrix of the running sum with skip and take of each number.
  
  Time Complexity = O(n)
  Space Complexity = O(n)
  */
  public int rob(int[] nums) {
      int[][] dp = new int [nums.length][2];
      
      dp[0][0] = 0;
      dp[0][1] = nums[0];
      
      for(int i = 1; i < nums.length; i++){
          dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
          
          dp[i][1] = nums[i] + dp[i-1][0]; //take current and the skip of previous number
      }
      
      return Math.max(dp[nums.length-1][0], dp[nums.length-1][1]); // At the last number, return max of the sum when you pick and don't pick the number.
  }

  /**
    Approach - 2
    
    Maintain only 2 variables:
        skip : that counts the total you can get by skipping the current number.
        take : that counts the total you can get by taking the current number.
    
    Time Complexity: O(n)
    Space complexity: O(1)
    */
    
    public int rob(int[] nums) {
      int skip = 0, take = 0;
      
      take = nums[0];
      for(int i = 1; i < nums.length; i++){
          int temp_skip = skip;
          skip = Math.max(skip, take);
          take = nums[i] + temp_skip;
      }
      
      return Math.max(skip, take);
    }
}
