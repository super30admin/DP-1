class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        // int [][] dp = new int[nums.length][2];
        // dp[0][1] = nums[0];
        int skip = 0;
        int take = nums[0];
        for(int i = 1; i <nums.length; i++){
            int temmp = skip;
            skip = Math.max(skip,take);
            take = nums[i] + temmp;
        }
       return Math.max(skip,take); 
    }
   
}
//TC: O(N)
