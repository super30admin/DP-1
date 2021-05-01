class Solution {
    public int rob(int[] nums) {
        int take=0; int skip=0;
        for(int i=0;i<nums.length;i++){
            int temp = take;
            take = skip+nums[i];
            skip = Math.max(skip,temp);
        }
        return Math.max(skip,take);
    }
}
