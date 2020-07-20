//Problem: 322. Coin Change
/** 3 Pointer Approcach: 
 * Used Dp and plotted a 2D array for 0-Amount and 0 and given coins.
 * The choice of using DP become obvious finding through BruteForce that 
 * it can be solved using sub problems.
 * The sub problems were repetitive fot brute force.
 * 
Example => Amount => 0 to 11 and coins => [0, 1, 2, 5]
0, 999999, 999999, 999999, 999999, 999999, 999999, 999999, 999999, 999999, 999999, 999999, 
0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 
0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 
0, 1, 1, 2, 2, 1, 2, 2, 3, 3, 2, 3, 
 */ 
//
//time Complexity :
// O(N * M) => Number of coins and Amount

// Space Complexity :
// O(N * M) => Number of coins and Amount

// Did this code successfully run on Leetcode : YES.
// Any problem you faced while coding this : NO. Initially took some time to comprehend the logic, later it was intiutive.

class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int rowLen = coins.length+1;
        int colLen = amount+1; 
        
        int[][] dp = new int[rowLen][colLen];
        
        //Arrays.fill(dp[0], 1, colLen, Integer.MAX_VALUE);
        
        for(int row = 0; row < rowLen; row++){
         dp[row][0] = 0;  
        }
        
        for(int col = 1; col < colLen; col++){
         dp[0][col] = 999999;  
        }
        
        for(int row = 1; row < rowLen; row++){
          
            for(int col = 1; col < colLen; col++){
             
             if(coins[row-1] > col){
                 dp[row][col] = dp[row-1][col];
                 continue;
             }
             dp[row][col] = Math.min(dp[row-1][col], dp[row][col - coins[row-1]] +1) ;
             
            }
        }
        
//         for(int row = 0; row < rowLen; row++){
          
//             for(int col = 0; col < colLen; col++){
             
//              System.out.print(dp[row][col] + ", ");
             
//             }
//              System.out.println("");
//         }
        
        
        return dp[rowLen-1][colLen-1] >= 999999? -1: dp[rowLen-1][colLen-1];
    }
}