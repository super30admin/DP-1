// Time Complexity : O(n) [n = nums.length]
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : Yes, Not able to determine base case, had to watch youtube videos multiple no. of times


// Your code here along with comments explaining your approach


class HouseRobber {
    public int rob(int[] nums) {
        // int n = nums.length;
        
        // return helperRecursion(nums, n-1);

        // int [] dp = new int [n];
        // Arrays.fill(dp, -1);
        // return helperMemoization(nums, n-1, dp);

         return helperTabulationOptimized(nums);
    }

    // private int helperRecursion(int []nums, int n) {
    //      if ( n < 0) {
    //         return 0;
    //     }

    //     if (n == 0) {
    //         return nums[0];
    //     }

    //     int include = helperRecursion(nums, n -  2) + nums[n];
    //     int exclude =  helperRecursion(nums, n -  1) + 0;

    //     return Math.max(include, exclude);
    // }

    //  private int helperMemoization(int []nums, int n, int [] dp) {
    //      if ( n < 0) {
    //         return 0;
    //     }

    //     if (n == 0) {
    //         return nums[0];
    //     }

    //     if (dp[n] != -1) {
    //         return dp[n];
    //     }
    //     int include = helperMemoization(nums, n -  2, dp) + nums[n];
    //     int exclude =  helperMemoization(nums, n -  1, dp) + 0;

    //     dp[n] = Math.max(include, exclude);
    //     return dp[n];
    // }

    
    // private int helperTabulation(int []nums) {
    //     int n = nums.length;
    //     int [] dp = new int [n];
    //     Arrays.fill(dp, 0);
    //     dp[0] = nums[0];
    //     if(n > 1) {
    //         dp[1] = Math.max(nums[0], nums[1]);
    //     }
    //     for(int i = 2; i < n; i++) {
    //         int include = dp[i - 2] + nums[i];
    //         int exclude = dp[i - 1] + 0;
    //         dp[i] = Math.max(include, exclude);
    //     }

    //     return dp[n - 1];
    // }

     private int helperTabulationOptimized(int []nums) {
        int n = nums.length;
        
        //Base case
        int prev2 = 0;

        //Previous value, since I'm only interested in adjacent spaces so, for ith idx is previous two values
        int prev1 = nums[0];

        for(int i = 1; i < n; i++) {
            // for include  prev2 value plus current idx value
            int include = prev2 + nums[i];
            // Ifor exclude prev value plus 0
            int exclude = prev1 + 0;
            //Takes max of both values
            int ans = Math.max(include, exclude);
            //shifts prev2 to prev1 and current and as prev1
            prev2 = prev1;
            prev1 = ans;
        }

        return prev1;
    }
    
}