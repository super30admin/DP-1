// Time Complexity : o(n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

//whenever making a deciison whether to choose or not choose, use dp

class Solution {
    public int rob(int[] nums) {
        int skip=0;
        int rob=0;
        for(int i=0;i<nums.length;i++)
        {
            int temp= skip;// store skip in temp variable, otherwise it will be chnaged when we use in next line
            skip = Math.max(rob,skip);//max, of the reccuring  profit at previous skipped house or robbed house
            rob = nums[i]+temp;//if we rob this means we skip previous, so add previous skipped plus current profit
        }        
        return Math.max(skip, rob);
    }
}