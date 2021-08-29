// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int rob(int[] nums) {
        // return 0 of array is null or empty
        if(nums == null || nums.length == 0) return 0;
        // initalize skip and take variables
        int skip = 0;
        int take = nums[0];
        for(int i = 1; i < nums.length; i++){
            // for each element in array
            // store the skip variable
            int temp = skip;
            // update the skip variable to previous element's maximum between skip or take
            skip = Math.max(skip, take);
            // update the take variable to maximum between previous element's take
            // or previous element's skip + current element
            take = Math.max(take, temp + nums[i]);
        }
        // return the the maximum of skip or take
        return(Math.max(skip, take));
    }
}