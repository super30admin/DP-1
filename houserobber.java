// TC: O(n)
// SC: O(1)
// Works on Leetcode
// No problem faced
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0 || nums == null) {
            return 0;
        }
        
        int skip = 0;
        int take = nums[0];
        
        for(int i = 1; i < n; i++) {
            int temp = skip;
            skip = Math.max(skip, take);
            take = temp + nums[i];
        }
        return Math.max(take, skip);
    }
}
