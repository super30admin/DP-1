// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int rob(int[] nums) {

        int n = nums.length;
        
        if(n==1)
            return nums[0];

        //try greedy and fail it
        //explore all paths and apply brute force - gives TLE : look at each house and decide to choose it or not
        //find repeated subproblems and optimise using DP

        //one constraint - houses, so dp array is required but we'll take 2D array to visualize both choose and don't choose case

        int[][] dp = new int[n][2];
        //dp[i][0] = value of robbed amount if current house is not chosen
        //dp[i][1] = value of robbed amount if current house is chosen

        //fill in first row - first house choices

        dp[0][0] = 0;
        dp[0][1] = nums[0];

        for(int i=1; i<n; i++)
        {
            //don't choose current house case
            //max of prev row - we don't know prev house was chosen or not, take max of either case since we need to maximise robbed amount
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);

            //choose current house case
            //current house amt + don't choose case of prev house
            dp[i][1] = nums[i] + dp[i-1][0];
        }

        //ans will be max of either case of last row/house
        return Math.max(dp[n-1][0], dp[n-1][1]);

    }
}
