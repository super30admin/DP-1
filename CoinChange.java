class CoinChange {
    public int coinChange(int[] coins, int amount) {
        // Time Complexity : O(n^2) or O(nm)
        //  Space Complexity : O(mn)

        int[][] dp = new int[coins.length+1][amount+1];
        
       //Fill the first column with 0 since amount is 0 
        for(int i = 0; i <= coins.length; i++){
            dp[i][0] = 0;
        }
        
	// Filling the first row with infinity or Max-value since coin is 0
        for(int i = 1; i <= amount; i++ ){
            dp[0][i] = 99999;
        }
        
	// Evaluating the matrix
	// If less than coin denomination --> previous row values
	// If not then Min( Upper cell, 1 + x steps backwards)
        for(int i = 1; i <= coins.length; i++){
            for(int j = 1; j <= amount; j++){
                if(j < coins[i-1])
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j-coins[i-1]]);
            }
        }
        
        return dp[coins.length][amount] >= 99999 ? -1 : dp[coins.length][amount];
        
    }
}
