/**
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
 *Algo: LC-198  (The 2d array which we make)
 1. First we create the 2d array dp with dim: nums.length * 2
 2. Initialize 1st row with: 0 and the number itself
 3. Iterating over each cell:
        if 0th-col: take max from the values of above row
        if 1st-col: take diagonal left element +  the current number
4. Return Max(last-row values)
 */
package DP;

public class HouseRobberDP {
    public static int rob(int[] nums){

        if(nums == null || nums.length == 0) return 0;
        int[][] dp = new int[nums.length][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for(int i = 1; i < nums.length; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = dp[i-1][0] + nums[i];
        }
        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
    }

    public static void main(String args[]){

        int[] nums = new int[]{2,7,9,3,1};
        System.out.println("Maximum amount that can be robbed: "+ rob(nums));
    }
}
