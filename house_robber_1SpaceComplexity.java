// Time Complexity : o(n)
// Space Complexity :o(1) we just using variables temp, skip, take
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int skip = 0, take = nums[0], temp;
        for(int i = 1; i < nums.length; i++) {
            temp = skip;
            skip = Math.max(skip, take);
            take = temp + nums[i];
        }
        return Math.max(skip, take);
    }
}