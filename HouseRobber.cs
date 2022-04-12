using System;
using System.Collections.Generic;
using System.Text;

namespace DynamicProgramming
{
    public class HouseRobber
    {
        /*
         * T.C: O(N): since we are iterating through whole array;
         * S.C: O(N): we are using extra space to store the value of each nums in an array of length nums.Length
         */
        public int Rob(int[] nums)
        {
            int[,] dp = new int[nums.Length + 1, 2];
            dp[0, 1] = nums[0];

            for (int i = 1; i < nums.Length; i++)
            {
                dp[i, 0] = Math.Max(dp[i - 1, 0], dp[i - 1, 1]);
                dp[i, 1] = nums[i] + dp[i - 1, 0];

            }

            return dp[nums.Length, 1];
        }



        /*
         * T.C:  O(N): since we are iterating through whole array;
         * S.C: O(1): We are storing the result into one variable.
         */

        public int Rob1(int[] nums)
        {
            int skip = 0;
            int take = nums[0];

            for (int i = 1; i < nums.Length; i++)
            {
                int temp = skip;
                skip = Math.Max(skip, take);
                take = temp + nums[i];
            }

            return Math.Max(skip, take);
        }
    }
}
