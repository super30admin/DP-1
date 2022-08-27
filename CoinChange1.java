/**
 * Problem1 (https://leetcode.com/problems/coin-change/)
 
Time Complexity :   O (M * N) 
Space Complexity :  O (M * N) 
Did this code successfully run on Leetcode :    Yes (322. Coin Change)
Any problem you faced while coding this :       No
 */

public class CoinChange1 {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0)
            return 0;
         
         int m = coins.length;
         int n = amount;
         int[][] dp = new int[m+1][n+1];
         
         dp[0][0] = 0;
         
         // make top row infinity
         for (int col = 1; col < dp[0].length; col++){
             dp[0][col] = amount + 1;
         }
         
         
         for (int row = 1; row < dp.length; row++){
             for (int col = 1; col < dp[0].length; col++){
                 // until amount is not eqaual to denomination
                 // NOT choose case, copy from existing value (row-1)
                 if (col < coins[row -1]){
                     dp[row][col] = dp[row-1][col];
                 }
                 else{
                     dp[row][col] = Math.min( dp[row-1][col], 1 + dp[row][col - coins[row-1]]);
                 }
             }
         }
         // Invalid case
         if (dp[m][n] > amount){
             return -1;
         }
         return dp[m][n];
     }

     public static void main(String args[]) 
     { 
        CoinChange1 obj = new CoinChange1();
        int[] coins = {1,2,5};
        int amount = 11;
        System.out.println(obj.coinChange(coins, amount));
     }
}
