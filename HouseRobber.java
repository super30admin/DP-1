class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int[] dp = new int[nums.length+2];
        
        for(int i = 0 ;i < nums.length;i++){
                dp[i+2] = Math.max(dp[i] + nums[i], dp[i+1]); 
        }
    return dp[nums.length+1];
    }
}