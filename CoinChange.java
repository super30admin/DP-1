class Solution {
    public int coinChange(int[] coins, int amount) {
     
        /*
        *  Timecomplexity: O(coins.lenght * amount)
        *
        * Space complexity: O(coins.lenght * amount)
        *
        **/
        
        // Adding 1 as we need to accomodate extra row for not possible case
        int [][] dp = new int [coins.length + 1] [amount +1];
        
        for(int k = 1; k < dp[0].length; k++) {
            dp[0][k] = 99999;
        }
        
        
        for(int i = 1; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                
                
                // If the amount to make is larger than current coin, 
                // then we cannot choose that coin, in that case copy from the above row
                
                if(coins[i - 1] > j ) {
                  dp[i][j] = dp[i-1][j];  
                }
                
                // For every sub amount that we need to form using given coins 
                // we have 2 cases, choose & not choose.
                
                else {
                    // Not choose case: is just above the cell ie.. currentRow - 1
                    int notChoose = dp[i-1][j];
                    
                    // Adding 1 to exisiting coins count since we choose this 
                    // Choose case is: coins[i] steps backward in the current row
                    // dp[i][j - coins[i]]
                    // using coins[i-1] since there is a dummy row we added at 0th level.
                    int choose = 1 + dp[i][j - coins[i-1]];
                    dp[i][j] = Math.min(notChoose, choose);
                }
            }
        }
        
        //If last row last column is still >= 99999 
        //meaning we are not able to form the amount with given coins
        
        int result = dp[dp.length - 1 ][dp[0].length - 1];
        if(result >= 99999) return -1;
        
        return result;
        
        
    }
}
