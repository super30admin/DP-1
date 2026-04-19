// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public int rob(int[] nums) {
        if(nums.length < 2) return nums[0];
        int len = nums.length;
        int prev = nums[0];
        int current = Math.max(nums[0],nums[1]);
        for(int i = 2;i<len;i++){
            int temp = current;
            current = Math.max(current,nums[i] + prev);
            prev = temp;
        }
        return current;
    }
}