// Time: O(n)
// Space: O(n+1) = O(n)
class Solution {
    public int rob(int[] nums) {
      if(nums == null || nums.length ==0){
        return 0;
      }
      
      
      int[] dp = new int[nums.length+1];
      dp[0] = nums[0]; // Choosing first
      int C = dp[0]; int DC = 0; // maximum values when Chose or Don't Choose a value of nums[i]
      for(int i=1;i<nums.length;i++){
        C = nums[i] + DC;
        DC = dp[i-1];
        dp[i] = Math.max(C,DC);
      }
      return dp[nums.length-1];
    }
}
