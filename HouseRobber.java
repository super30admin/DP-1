// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int rob(int[] nums) {
        int skip=0;// value if the present number is skipped
        int take=nums[0]; //if the value is taken
        //since we have done for the first one, we iterate from 1
        for(int i=1;i<nums.length; i++){
            int temp= skip;
            //calculate skip value for i by taking maximum value of previous
            skip= Math.max(skip,take);
            take= nums[i]+temp;
        }
        //return the max including the last one
        return Math.max(skip,take);
    }
}