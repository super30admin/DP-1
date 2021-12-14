// Time Complexity : O(coins.length * amount)
// Space Complexity : O(coins.length * amount)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins.length == 0 || coins == null || amount == 0)return 0;

        int[][] dp = new int[coins.length + 1][amount + 1];
        dp[0][0] = 0;
        for(int col = 1; col < dp[0].length;col++)dp[0][col] = amount + 1;

        for(int row = 1; row < dp.length;row++){
            for(int col = 0; col < dp[0].length;col++){
                if(col < coins[row-1])dp[row][col] = dp[row-1][col];
                else{
                    dp[row][col] = Math.min(dp[row-1][col], 1 + dp[row][col - coins[row - 1]]);
                }
            }
        }

        if(dp[dp.length-1][dp[0].length - 1] > amount)return -1;
        return dp[dp.length-1][dp[0].length - 1];
    }
}
  