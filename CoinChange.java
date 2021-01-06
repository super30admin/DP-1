/**

Leetcode: 322 Coin Change Problems 

You are given coins of different denominations and a total amount of money amount. 
Write a function to compute the fewest number of coins that you need to make up that amount. 
If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

Time Complexity : O(M*N)
Space Complexity : O(M*N)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

**/
class Solution
{
    public int coinChange(int[] coins, int amount) 
    {
        
        if( coins == null || coins.length ==0)
            return 0;
        
        int matrix[][] = new int[coins.length + 1][amount+1];
        
        for(int j=1; j<matrix[0].length; j++)
            matrix[0][j] = 99999;
        
        for( int i=1; i< matrix.length; i++)    
        {
            for(int j=1; j<matrix[0].length; j++)
            {
                
                if(coins[i-1] > j) {
                    matrix[i][j] = matrix[i-1][j];
                }
                else
                {
                    matrix[i][j] = Math.min(matrix[i-1][j], 1 + matrix[i][j-coins[i-1]]);
                }
            }
        }
        
        int result = matrix[matrix.length-1][matrix[0].length -1];
        
        if(result >= 99999) return -1;
        
        return matrix[matrix.length-1][matrix[0].length -1];
        
    }
}