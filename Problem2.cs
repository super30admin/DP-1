// Time Complexity : O(n) where m is the total length of nums array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


public class Solution
{
    public int Rob(int[] nums)
    {
        for (int i = 0; i < nums.Length; i++)
        {
            int secondPrev = (i - 2) >= 0 ? nums[i - 2] : 0;
            int firstPrev = (i - 1) >= 0 ? nums[i - 1] : 0;

            nums[i] = Math.Max(secondPrev + nums[i], firstPrev);
        }

        return nums[nums.Length - 1];
    }
}