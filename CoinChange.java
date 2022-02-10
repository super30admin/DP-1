// Time Complexity :  O(C * A) where C is the denominations of coin and A is the amount.
// Space Complexity : O(C * A) where C is the denominations of coin and A is the amount.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Create a 2d array of size index * amount to store the solved values.
// Create another function which will run recursively either taking a coin or not taking
// This function when run, would keep decreasing the possible search space, leading to exit condition

class Solution {
    private int[][] dp;
    public int coinChange(int[] coins, int amount) {
        dp = new int[coins.length][amount + 1];
        int ans = coinChange(coins, 0, amount);
        return ans == Integer.MAX_VALUE?-1:ans;
        
        }
    private int coinChange(int[] coins, int index, int amount){
        if(amount == 0)
            return 0;
        if( amount < 0 || coins.length == index)
            return Integer.MAX_VALUE;
        if(dp[index][amount] != 0)
            return dp[index][amount];
        
        int notChoose = coinChange(coins, index+1, amount);
        int choose = coinChange(coins, index, amount - coins[index]);
        if(choose != Integer.MAX_VALUE)
            choose +=1;
        int min = Math.min(notChoose, choose);
   
        dp[index][amount] = min;
        return dp[index][amount];
    }
    
}