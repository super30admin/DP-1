// Tabulation method
// Time Complexity : O(m*n); m -> amount; n -> no. of coins
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes  
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * As part of recursive solution, it was observed that there are two parameters which may change: the amount and the index. 
 * Therefore, we need to consider a 2 dimension array for tabulation. 
 * The length of rows will be coins.length +1 to help considering the scenario when the given amount cannot me made.
 * The length of columns will be amount +1, for considering the scenario when 0 amount is made.
 * While iterating, we will take the minimum coins considering previous denominations or the number of coins required with current denomination
 */

class CoinChangeDP {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0) {
            return -1;
        }
        int[][] dp = new int[coins.length+1][amount+1];
        for(int i = 0; i < amount+1; i++) {
            dp[0][i] = amount+1;
        }
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                if(j >= coins[i-1]) {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-coins[i-1]]+1);
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1] > amount ? -1 : dp[dp.length-1][dp[0].length-1];
    }
}