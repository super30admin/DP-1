// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No, but in C# I felt the 2D arrays are a bit tricky and not intutional. So 
// I decided to choose java as my language for coding these parts on leet code.

//Time Complexity : O(m * n) since we are iterating through the matrix 
//Space Complexity: O(m * n) since we are taking extra 2D array 

public int coinChange(int[] coins, int amount) {
         if(coins == null || coins.length == 0) return 0;
        
         var dp = new int[coins.length + 1][amount + 1];
         
        //fill first column
         for(int i=0; i < dp.length; i++){
             dp[i][0] = 0;
         }
         
        //fill first row
         for(int j = 1; j < dp[0].length; j++){
             dp[0][j] = amount + 1;
         }
        
        //iterate and fill the dp matrix
        for(int i = 1; i < dp.length; i++){
            for(int j=1; j < dp[0].length; j++){
                
                // Until the amount equals denomination, min will be just the case above
                if(j < coins[i-1]){
                    //zero case
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j - coins[i-1]] + 1);
                }
            }
        }
        var result = dp[dp.length-1][dp[0].length-1];
        return result >= amount+1 ? -1 : result;
    }
