// Time Complexity : O(m*n) where m is the total number of coins and n is the total amount
// Space Complexity : O(n) where n is the total amount
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


public class Solution
{
    public int CoinChange(int[] coins, int amount)
    {
        int rows = coins.Length + 1;
        int columns = amount + 1;

        int[] dp = new int[columns];

        // Fill all but first element with amount + 1

        for (int j = 1; j < columns; j++)
        {
            dp[j] = amount + 1;
        }

        // D.P

        for (int i = 1; i < rows; i++)
        {
            for (int j = 1; j < columns; j++)
            {
                if (j >= coins[i - 1])
                {
                    dp[j] = Math.Min(dp[j], 1 + dp[j - coins[i - 1]]);
                }
            }
        }

        return dp[columns - 1] <= amount ? dp[columns - 1] : -1;
    }
}