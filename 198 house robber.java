class Solution {// time and space of O(n)
    public int rob(int[] nums) {
        // base case 
        if(nums == null || nums.length == 0) 
            return 0;
        if(nums.length == 1)
            return nums[0];
     // space to store previous result
        int[] dp = new int[nums.length];
      //  int max_money = 0;
    // base case
        dp[0] = nums[0];
       dp[1] = Math.max(nums[0], nums[1]) ;
        //dp[1] =  nums[1] ;
        for(int i = 2; i< nums.length ; i++){
            // main calculation
            dp[i] = Math.max(nums[i]+ dp[i-2], dp[i - 1]);
        }
        return dp[nums.length - 1];
        // int[] memo = new memo[nums.length - 1];
        // also need to fill the array with -1 initial value
        // public int rob(int[] nums, int i){
        //     //Base case 
        //     if (i<0)
        //         return 0;
        //     if (memo[i]>=0) 
        //         return memo[i];
        //     int result = Math.max(rob9(nums, i - 2 ) + nums[i],rob(nums, i-1))
        //     memo[i] = result ;
        //         return result;
        // }
    }
}
