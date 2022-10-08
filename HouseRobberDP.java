// Time Complexity : O(n)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
// Dp Solution
class Solution {
    public int rob(int[] nums) {
        // base case
        if (nums == null || nums.length == 0) return 0;

        int amount = 0;
        int n = nums.length;
        int[][] dp = new int[n][2];
        dp[0][1] = nums[0];


        for (int i=1; i<n; i++) {
            // do not rob case
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);

            // rob case
            dp[i][1] = nums[i] + dp[i-1][0];
        }

        return Math.max(dp[n-1][0], dp[n-1][1]);
    }

}



// ----------------------------------------------------------------------------->
// Recirsive approach
//class Solution {
//    public int rob(int[] nums) {
//        // base case
//        if (nums == null || nums.length == 0) return 0;
//
//        int amount = 0;
//
//        return helper(nums, 0, amount);
//
//    }
//
//    private int helper(int[] nums, int index, int amount) {
//        // base case
//        if(index >= nums.length) return amount;
//
//        // recursive cases
//        return Math.max(helper(nums, index+1, amount), helper(nums, index+2,  nums[index] + amount));
//    }
//}
