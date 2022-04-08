using System;
using System.Collections.Generic;
using System.Text;

namespace DynamicProgramming
{
    public class CoinChange
    {
        public int FindCoinChange(int[] coins, int amount)
        {
            int amt = amount + 1;
            int[,] dp = new int[coins.Length + 1,amt];

            for (int i = 1; i < amount+1; i++)
            {
                dp[0,i] = amount + 1;
            }

            for (int i = 1; i < coins.Length+1; i++)
            {
                for (int j = 1; j < amount+1; j++)
                {
                    if(j <coins[i-1])
                    {
                        dp[i, j] = dp[i - 1, j];
                    }
                    else
                    {
                        dp[i,j]= Math.Min(dp[i-1,j], 1 + dp[i,j-coins[i-1]]);
                    }
                }
            }

            if (dp[coins.Length + 1, amount + 1] == amount + 1)
                return -1;


            return dp[coins.Length + 1, amount + 1];

        }
    }
}
