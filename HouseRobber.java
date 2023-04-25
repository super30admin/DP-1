//tc=O(n)
//sc=O(1)
class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int skip = 0;
        int take = nums[0];      

        for (int i = 1; i < nums.length; i ++) {
            int temp = skip;
            skip = Math.max(skip, take);
            take = nums[i] + temp;      
        }
        return Math.max(skip, take);
    }
}