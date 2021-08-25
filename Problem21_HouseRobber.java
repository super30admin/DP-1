// Time Complexity : O(n), n -> length of the array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        if(nums.length == 2)
            return nums[0] > nums[1] ? nums[0] : nums[1];
        int second = nums[0];
        int first = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++) {
            int third = Math.max(first, nums[i] + second);
            second = first;
            first = third;
        }
        return first;
    }
}