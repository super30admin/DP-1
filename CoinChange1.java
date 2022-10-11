class CoinChange1 {
    public int coinChange(int[] coins, int amount) {
        
        if(coins == null || coins.length == 0){
            return -1;
        }
        
        int m = coins.length;
        int n = amount;
        int[][] dp = new int[m+1][n+1];  // +1 to add extra row and column for 0
        
        //fill first row starting from 1 with Infinity/Max_Value/Amount+1
        for(int j = 1; j < n+1; j++){
            dp[0][j] = amount+1;
        }
        
        //First column is default 0 (Java) So don't have to fill it
        
        //Traverse the m * n matrix and start filling the coins used
        for(int i = 1; i < m+1; i++){
            for(int j = 1; j < n+1; j++){
                // coin < amount => we can't form amount with it 
                //means (Case 1 = choose not possible) ==> only case 0 gives result so simply copy just above value
                
                if(j < coins[i-1]){
                   dp[i][j] = dp[i-1][j];  
                }
                else{ 
                    //min(case0, 1+case1)
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j - coins[i-1]]);
                }
            }
        }
        //If final cell value is greater than amount means we can't form given amount with given coin(s)
        if(dp[m][n] > amount){
            return -1;
        }

        return dp[m][n];
    }
}

//Time Complexity: O(m * n) // m = number of coins, n = amount
//Space Complexity: O(m * n) 
