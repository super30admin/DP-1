//Time complexity: O(N)
//Space complexity: O(1)
class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int skip = 0;
        int take = nums[0];
        for(int i = 1; i < nums.length; i++) {
            int temp = skip;
            skip = Math.max(skip, take);
            take = temp + nums[i];
        }
        return Math.max(skip, take);
    }
}