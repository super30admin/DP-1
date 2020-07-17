
// Time Complexity : O(nk), n = number of coins, k is the amount 
// Space Complexity : O(nk)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

// Approach:
// 1. I used Dynamic Programming to find out the minimum number of coins.
// 2. Initialized the DP matrix' first row, with out of bound number, like (amount+1), so that next rows can be compared with the earlier row.
// 3. On every iteration, I compare the numbers above the current pointer and the one which is at (j-x) column in the same row, where j being the current column
// and x being the value of current coin. I take the minimum of the two and place it at the current position.
// 4. Element at the last index of the DP matrix gives me the minimum number of coins required.

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int [coins.length+1][amount+1];
        
        dp[0][0] = 0;
        for(int i = 1; i < coins.length+1; i++){
            dp[i][0] = 0;
        }
        for(int j = 0; j < amount+1; j++){
            dp[0][j] = amount+1;
        }
        
        for(int i = 1; i < coins.length + 1; i++){
            for(int j = 1; j < amount + 1; j++){
                if(coins[i-1] > j){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j - coins[i-1]]+1);
                }
            }
        }    
        return dp[coins.length][amount] < amount+1 ? dp[coins.length][amount] : -1;
    }
}
