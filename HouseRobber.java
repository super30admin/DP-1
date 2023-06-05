class HouseRobber {
    // recursive approach;
    // time complexity 2^n-- nums.length
      public int robRecursion(int[] nums) {
          return helper(nums, 0, 0);
      }

     private int helper(int[] nums, int idx, int amountRobbed) {

         if(idx >= nums.length) {
             return amountRobbed;
         }

         //logic
         //case 1: choose current house
         int case1 =  helper(nums, idx + 2, amountRobbed + nums[idx]);
         //case 2: skip current house
         int case2 =  helper(nums, idx + 1, amountRobbed);

         return Math.max(case1,case2);
     }

     // dp bottom up solution
    // time complexity : n(length of array)
    //space complexity: n
     public int robDpTabulation(int[] nums) {

         if(nums.length == 1) {
             return nums[0];
         }

         int[] dp = new int[nums.length];

         dp[0] = nums[0];
         dp[1] = Math.max(dp[0], nums[1]);

         for(int i = 2; i < nums.length; i++) {

             int caseChoose = nums[i] + dp[i - 2];
             int caseSkip = dp[i - 1];
             dp[i] = Math.max(caseChoose, caseSkip);
         }

         return dp[nums.length - 1];

     }

    // dp bottom up solution space optimized
    // time complexity : n(length of array)
    //space complexity: constant
    public int robDpOptimized(int[] nums) {

        if(nums.length == 1) {
            return nums[0];
        }

        int max = 0;
        int prevPrevMax = nums[0];
        int prevMax = Math.max(prevPrevMax, nums[1]);

        for(int i = 2; i < nums.length; i++) {

            int caseChoose = nums[i] + prevPrevMax;
            int caseSkip = prevMax;
            max = Math.max(caseChoose, caseSkip);

            prevPrevMax = prevMax;
            prevMax = max;
        }

        return prevMax;

    }
}