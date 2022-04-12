// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public class Solution {
    public int Rob(int[] nums) {
        if(nums == null || nums.Length == 0)
            return 0;

        int n = nums.Length;

        //initialize skip to 0 and take to first element in array
        int skip = 0;
        int take = nums[0];

        for(int i = 1; i < nums.Length; i++)
        {
            //we take skip max of previous skip or take
            //and wea take take as previous skip + current element
            int temp = skip;
            skip = Math.Max(skip, take);
            take = temp + nums[i];
        }
        return Math.Max(skip, temp);
    }
}