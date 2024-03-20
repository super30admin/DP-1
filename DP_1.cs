using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace S30_Problems
{
    class Program
    {
        static void Main(string[] args)
        {
            Program p = new Program();
            int a = p.CoinChange(new int[] { 1, 2, 5 }, 100);
        }

        // Time Complexity = O(n)
        // Space Complexity = O(1)
        public int Rob(int[] nums)
        {
            if (nums.Length == 1) return nums[0];
            int prev = 0, curr = nums[0];
            for (int i = 1; i < nums.Length; i++)
            {
                int temp = curr;
                curr = Math.Max(nums[i] + prev, curr);
                prev = temp;
            }
            return curr;
        }
        // Time Complexity = O(m * n) where m is the number of coins and n is the amount 
        // Space Complexity = O(n)
        public int CoinChange(int[] coins, int amount)
        {
            int[] dp = Enumerable.Repeat(amount + 1, amount + 1).ToArray();
            dp[0] = 0;
            for (int i = 1; i <= amount; i++)
            {
                foreach (int coin in coins)
                {
                    if (i - coin < 0) continue;
                    dp[i] = Math.Min(dp[i], dp[i - coin] + 1);
                }
            }
            return dp[amount] == amount + 1 ? -1 : dp[amount];
        }
    }
}
