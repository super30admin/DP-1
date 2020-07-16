/**
Problem: Find the min number of coins needed to make a given amount

Time Complexity: O(A*n), where A is the amount needed and n is the number of coins
Space Complexity: O(A*n), as we use a matrix of size A * n, where A is the amount needed and n is the number of coins
Did this code successfully run on Leetcode : Yes

Approach : Dynammic Programming.
1. Create a matrix where the rows are the denominations of coins that are available to us, and columns are the amounts from 0 to A.
2. At every cell in the matrix, there are only two possible choices:
    a)amount x includes the largest coin 
    b) amount x does not include the largest coin 
3. Among these two choices, we always choose the minimum.
4. This way, we compute the whole matrix, and the minimum num of coins needed is present in the last cell of the matrix.
*/


class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length+1][amount+1];
        for(int i = 0; i<=coins.length; i++) {
            dp[i][0] = 0; // no. of ways needed to make 0 with 0 coins 
        }
        for(int j = 1; j<= amount; j++) {
            dp[0][j] = 999999; // intialize the first row containing 0 coins to max value
        }
        for(int i = 1; i<=coins.length; i++) {
            for(int j = 1; j <= amount; j++) {
                if(j < coins[i-1]) {
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i][j] = Math.min(1+dp[i][j - coins[i-1]], dp[i-1][j]);//you either choose the coin or not choose the coin
                }
                
            }
        }
            
        int minNumCoins = dp[coins.length][amount];
        if(minNumCoins >= 999999)  return -1;
        else return minNumCoins;
        
    }
}