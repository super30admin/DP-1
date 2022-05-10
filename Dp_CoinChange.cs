using System;
namespace Algorithms
{
    public class Dp_CoinChange
    {
        /// Time Complexity : O(N*amount) 
        // Space Complexity :O(amount) 
        // Did this code successfully run on Leetcode :Yes
        // Any problem you faced while coding this :  No
        public int CoinChange(int[] coins, int amount)
        {
            int rows = coins.Length + 1;
            int columns = amount + 1;
            int[][] dp = new int[rows][];
            for (int i = 0; i < rows; i++)
            {
                dp[i] = new int[columns];
            }
            for (int j = 1; j < columns; j++)
            {
                dp[0][j] = 9999;
            }
            for (int row = 1; row < rows; row++)
            {
                for (int column = 1; column < columns; column++)
                {
                    if (column < coins[row - 1])
                    {
                        dp[row][column] = dp[row - 1][column];
                    }
                    else
                    {
                        dp[row][column] = Math.Min(dp[row - 1][column], 1 + dp[row][column - coins[row - 1]]);
                    }
                }
            }
            int result = dp[rows - 1][columns - 1];
            if (result >= 9999) return -1;
            else return result;
        }
    }
}
