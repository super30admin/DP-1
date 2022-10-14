// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {

    private int[][] dp;

    public int coinChange(int[] coins, int amount) {
        
        dp = new int[coins.length][amount+1];

        int ans = coinChange(coins, 0, amount);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    /*
        Minimum no.of coins required to make amount using denomiantion from coins[index] to coins[n-1]
    */
    private int coinChange(int[] coins, int index, int amount){
        //base
        //valid
        if(amount == 0)
        {
            return 0;
        }
        //invalid
        if(amount < 0 || index == coins.length){
            return Integer.MAX_VALUE;
        }
        if(dp[index][amount] == 0){

            //recursion
            //select
            int select = coinChange(coins, index, amount - coins[index]);

            if(select != Integer.MAX_VALUE){
                select += 1;
            }
            //not select
            int notSelect = coinChange(coins, index+1, amount);
            dp[index][amount] = Math.min(select, notSelect);

        }
        return dp[index][amount];
    }
}