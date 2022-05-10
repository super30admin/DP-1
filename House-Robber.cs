using System;
namespace Algorithms
{
    public class House_Robber
    {
        /// Time Complexity : O(N)
        // Space Complexity :O(1) 
        // Did this code successfully run on Leetcode :Yes
        // Any problem you faced while coding this :  No
        public int Rob(int[] nums)
        {
            if (nums == null || nums.Length == 0) return 0;
            if (nums.Length < 2) return nums[0];
            int n = nums.Length;
            int choose = nums[0];
            int notChoose = Math.Max(nums[0], nums[1]);
            for (int i = 2; i < n; i++)
            {
                int temp = choose;
                choose = Math.Max(choose, notChoose);
                notChoose = nums[i] + temp;
            }
            return Math.Max(choose, notChoose);
        }
    }
}
