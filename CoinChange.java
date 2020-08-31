/*
 * #322. Coin Change
 * 
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:

Input: coins = [1, 2, 5], amount = 11
Output: 3 
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Note:
You may assume that you have an infinite number of each kind of coin.

 */

/*
 * Time Complexity: O (NxM) -> traversing through rows and columns in matrix
 * 
 * Space Complexity: O (NxM) -> N = No of rows, M = No of columns, not same
 * 
 * Did this code successfully run on leetcode: Yes
 * 
 * Any problem you faced while coding this: No
 * 
 */

package com.s30.edu.DP1;

public class CoinChange {
	
public int coinChange(int[] coins, int amount) {
        
		// Create a 2D matrix with 'coins.length+1' rows and 'amount+1' columns
        int[][] dp = new int[coins.length+1][amount+1];
        
        /*
         * Fill up the first column with 0
         * The minimum no of coins required to make amount = 0 with any denomination is 0
         */
        for(int i = 0; i <=coins.length; i++){
            dp[i][0] = 0;
        }
        
        /*
         *  Fill up the first row starting from second column since first is already filled with 'infinity/99999 -> Integer MAX value'  
         *  because, minimum number of coins required to make any amount from '0' is not possible, so fill with infinity value
         */    
        for(int j = 1; j <= amount; j++){
            dp[0][j] = 99999; // Int Max -> Infinity value
        }
 
        /*
         * After filling up the first column and row 
         * Traverse through the remaining rows and columns of matrix
         * 
         * Check:
         * 	1. If the amount to make is less than given coin denomination
         * 	   - If yes, meaning we cannot make amount from given coin, but we can make amount from lesser denomination
         * 		 So, copy the value from top of matrix 
         *  2. Else, in other cases, we can make the amount from current and previous denominations
         *     In such cases, we go for choose or don't choose the current denomination
         *     DC:
         *     	- If we don't choose, then copy the minimum number of coins from top in matrix
         *     C:
         *     	- If we choose, e.g: from [1,2] make amount = 2
         *     		- then, we can make the amount by choosing higher denomination first (2 in this case)
         *     	      meaning, there is always 1 minimum number of coin to get the given amount (1 + minimum number of coins to make remaining amount)
         *     		- then we compute the remaining amount by subtracting the higher denomination just used (current coin) from the amount
         *     		- And, get the minimum number of coins value at index 'j' (remaining amount)
         *     Then, we take the minimum of both -> min(C, DC)
         *     
         * We repeat the steps 1 or 2 until all the values in matrix are filled
         * 
         * After exiting the for loop, before returning the last value in matrix (minimum number of coins)
         * 	- check if(last value in matrix >= infinity)
         * 		- If yes, return -1 -> could't make the given amount
         * 		- Else, return the last value in matrix -> minimum number of coins
         */
        
        for(int i = 1; i <=coins.length; i++){
            for(int j = 1; j <= amount; j++){
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j - coins[i-1]]);
                }
            }
        }
        
        return dp[coins.length][amount] >= 99999 ? -1 : dp[coins.length][amount];
        
    }

}
