/*
  Time complexity:O(n)
  Space complexity:O(n)

  Code ran successfully on Leetcode: Yes

  Approach: We compute a running sum where we make a decision as to select 1 or 0 and 2 for every sum element

*/

public class Solution {
    public int Rob(int[] nums) {
        
        int[] sum = new int[nums.Length];
        sum[0]=nums[0];
        
        if(nums.Length>1)
            sum[1]=Math.Max(nums[0],nums[1]);
        
        for(int i=2;i<nums.Length;i++)
        {
            sum[i] = Math.Max(sum[i-1], sum[i-2]+nums[i]);
        }
        
        return sum[nums.Length-1];
    }
}

