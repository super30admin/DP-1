// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no


public class Problem2 {

    public int rob(int[] nums) {

        //null check
        if(nums==null || nums.length ==0) return 0;

        int n = nums.length;

        //if only one house is there
        if(n==1) return nums[0];

        //creating a new dp array of size n
        int[] dp = new int[n];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i=2; i<n; i++){

            dp[i] = Math.max(dp[i-1], nums[i]+dp[i-2]);

        }
        //dp started from index 0
        return dp[n-1];
    }

}
