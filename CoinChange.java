/*
* TC - O(N^2)
* space O(N^2)
* Ran on leetcode - yes
*/

class Solution {
    public int coinChange(int[] coins, int amount) {
      
        int[][] dp = new int[coins.length+1][amount+1];
        // insert a colum of zeroes
        for (int i = 0 ; i< dp.length; i++){
            dp[i][0] = 0;
        }
        // insert row of infinities
        for (int j = 0 ; j< dp[0].length; j++){
            dp[0][j] = 99999;
        }
        
        for (int i = 1; i <dp.length; i++){
            for (int j = 1; j <dp[0].length; j++) {
                
                // if demnomination is greater than thn the amount, add the previous row to the current row
                if (coins[i-1] > j){ // current coin is coins[i-1] , if its denomination > amount(j)
                    dp[i][j] = dp[i-1][j]; 
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j-coins[i-1]]); // current amount- cost of the current coin
                }
            }   
        }
        
        int result =  dp[dp.length-1][dp[0].length-1]; 
        if (result > amount) return -1;
        return result;
    }
    
}
