public class Solution
    {
        // Time Complexity : O(2^(m+n))
        // Space Complexity : O(1)
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this : No

        public int CoinChange(int[] coins, int amount)
        {
            int m = coins.Length;
            int n = amount;

            int[,] dp = new int[m + 1, n + 1];

            //initializing the first row with infinity or Int maxvalue
            for(int j = 1; j < n + 1; j++)
            {
                dp[0, j] = int.MaxValue - 10; //-10 so that when we add 1 to infinity it should not go out of range
            }

            for(int i = 1; i < m + 1; i++)
            {
                for(int j = 1; j < n + 1; j++)
                {
                    if (j < coins[i - 1]) // it is coins[i-1] becuase we are taking a dummy row
                    {
                        //take the value above it until the amount is >= coin denomination
                        dp[i, j] = dp[i - 1, j];
                    }
                    else
                    {
                        //Minimum of case0:value just above and case1:same row go coin denomination steps back + 1 since we choose the coin
                        dp[i, j] = Math.Min(dp[i - 1, j], dp[i, j - coins[i - 1]] + 1);
                    }
                }
            }
            //last row, last column is where the solution lies
            if (dp[m, n] >= int.MaxValue - 10)
                return -1;
            return dp[m,n];
        }
