// Time complexity : O(m *n)
// space complexity : O(m *n) 
// m = no of different coins (denominations)
// n = amount value

class Solution {
    public int coinChange(int[] coins, int amount) {
        // 2 D array : Rows -> coins , column -> (0-amount)
        int[][] dp =  new int[coins.length + 1][amount + 1];
        
        // First row
        for (int i = 1; i <= amount ; i++){
            dp[0][i] = amount + 1; // instead of mx value
        }
        
        // First column
        for (int i = 0; i <= coins.length ; i++){
            dp[i][0] = 0;
        }
        
        // Update other cells
        for (int i = 1; i <= coins.length; i++){
            
            for (int j = 1; j <= amount; j++){
                
                // new coin is less than the coin value
                if (j < coins[i-1]){
                    
                    // update the previous row value as its value
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    // Coin considered case, not considered case
                    dp[i][j] = Math.min( dp[i-1][j] , dp[i][j - coins[i-1]] + 1 );
                }
            }
        }
        
        return dp[coins.length][amount] == amount + 1 ? -1 : dp[coins.length][amount];
        
    }
}