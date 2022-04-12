/**
Problem: https://leetcode.com/problems/house-robber/
TC: O(n)
SC: O(1)
*/
class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int n = nums.length;
        int skip = 0;
        int take = nums[0];
        
        for (int i = 1; i < n; ++i) {
            // Case 1 : have not robbed house i
            int tempSkip = skip;
            skip = Math.max(skip, take);
            // Case 2 : robbing house i
            take = tempSkip + nums[i];
        }
        return Math.max(skip, take);
    }
}