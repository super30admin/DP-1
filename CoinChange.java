// Time Complexity : O(N*M) N = number of coins M = amount
// Space Complexity : O(N*M)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


/* Your code here along with comments explaining your approach
matrix dp N*M
rows = coins [0,1,3,5]
cols = amount [0...11]
dp[rows][cols] = number of coins for that cell
first column all 0's, first row Infinity (99999)
coins[i-1] because we are starting the matrix from [0,0] so matrix length should be [coins+1][amount+1]
dp[row][col] = choose the coin and then get the rest of amount from previous calulation/ don't choose - pick previously calculated value
*/

class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int dp[][] = new int[coins.length+1][amount+1];
        
        for(int i = 0; i <= coins.length; i++){
            dp[i][0] = 0;
        }
        
        for(int j = 0; j <= amount; j++){
            dp[0][j] = 99999; //Integer max infinity in this case
        }
        
        for(int i = 1; i <= coins.length; i++){
            for(int j = 1; j <= amount; j++){
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                } else {
                    // choose = 1 + dp[i][j - coins[i-1]] go back number of columns (coins)
                    // don't choose = select previous value dp[i-1][j]
                    // choose min from both
                    dp[i][j] = Math.min(1 + dp[i][j - coins[i-1]], dp[i-1][j]);
                }
            }
        }
        
        return dp[coins.length][amount] == 99999 ? -1 : dp[coins.length][amount];
    }
}
