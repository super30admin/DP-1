// Time Complexity : O(N) we have a loop from N - 2 to 0, we use the precalculated values of dp table to calculate the current value 
// Space Complexity : O(1) : we use 2 variables
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int rob(int[] nums) {
        int skip = 0, take = nums[0];
        for(int i = 1; i<nums.length; i++){
            int temp = skip;
            skip = Math.max(skip, take);
            take = nums[i] + temp;
        }
        return Math.max(skip, take);
    }
}