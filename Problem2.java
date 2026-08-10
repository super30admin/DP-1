
// house robber problem
// o(n) time complexity
// space complexity o(n)
// checking prefixsum and current sum at every position and return last element of array





class Solution {
    int maxTotal = Integer.MIN_VALUE;
    public int rob(int[] nums) {

      int[] dp = new int[nums.length];

      if(nums.length == 1) {
        return nums[0];
      }

      if(nums.length == 2) {
        return Math.max(nums[0], nums[1]);
      }


      int prefixSum = nums[0];
      int currentSum = Math.max(nums[0], nums[1]);

      for(int i = 2; i< nums.length; i++){

        dp[i] = Math.max(currentSum ,  prefixSum+nums[i]);
        prefixSum = currentSum;
        currentSum = dp[i];


      }

      return dp[nums.length - 1];
    }



}