class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length==0){
            return 0;
        }
        int skip = 0, take = nums[0]; // initially the optimal choice is to rob 1 
        for(int i=1;i<nums.length;i++){ // if we get further houses
            int temp = Math.max(skip,take); // should we change the decision? we keep that value in temp
            take = skip+nums[i]; // we rob current house by adding money to latest optimal solution value.
            skip = temp; // we update optimal solution
        }
        return Math.max(skip,take); // chose whether to skip or take from last house and return.
    }
}