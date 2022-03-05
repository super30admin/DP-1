// Time Complexity :o(n)
// Space Complexity :o(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach: dp approach

class Solution {
    public int rob(int[] nums) {
        int skip = 0;
        int take = nums[0];
        
        for(int i = 1;i< nums.length;i++)
        {
            int temp = skip;
            skip = Math.max(skip,take);
            take = temp+nums[i];
        }
        return Math.max(skip,take);
        
    }
}
