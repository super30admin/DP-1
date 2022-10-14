// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


//max amount to rob from ith to nth house
class Solution {

    int dp[];

    public int rob(int[] nums){
        dp = new int[nums.length];
        Arrays.fill(dp, -1);

        return rob(nums, 0);
    }

    private int rob(int[] amount, int i){
        //base case
        if(i >= amount.length){
            return 0;
        }

        //recursion
        if(dp[i] == -1){
            int robAmount = amount[i] + rob(amount, i+2);
            int notRobAmount = rob(amount, i+1);

            dp[i] = Math.max(robAmount, notRobAmount);
        }
        return dp[i];
    }
}