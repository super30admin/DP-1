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