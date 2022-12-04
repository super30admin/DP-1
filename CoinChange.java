// Time Complexity : O(mn) number of coins times amount
// Space Complexity : O(mn)

/*
 * the idea is to create a matrix to store the minimum coins required 
 * to form the amount and use that value to find the next value and so on.
 */

class CoinChange{
    public int coinChange(int[] coins, int amount) {
        int rows = coins.length;
        int columns = amount;
        int[][] dp = new int[rows+1][columns+1];
        
        dp[0][0] = 0;
        for (int i = 1; i <= columns; i++) dp[0][i] = amount+1; // basically infinity
        
        for (int i = 1; i <= rows; i++){
            for(int j = 1; j <= columns; j++){
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j - coins[i-1]]);
                }
            }
        }
        if(dp[rows][columns] > amount) return -1;
        return dp[rows][columns];
    }
}