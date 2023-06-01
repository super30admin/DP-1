// ## Problem2 (https://leetcode.com/problems/house-robber/)

// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

public class HouseRobber {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];

        dp[0] = 0;
        dp[1] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i + 1] = Math.max(dp[i], nums[i] + dp[i - 1]);
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        HouseRobber obj = new HouseRobber();
        int[] arr1 = { 1, 2, 3, 1 };
        int[] arr2 = { 2, 7, 9, 3, 1 };
        System.out.println("Maximum Robbed Amount for input arr1: " + obj.rob(arr1));
        System.out.println("Maximum Robbed Amount for input arr2: " + obj.rob(arr2));
    }
}
