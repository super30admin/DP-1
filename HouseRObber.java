class Solution {
    public int rob(int[] nums) {
        int n  = nums.length;
        if(n == 1){
            return nums[0];
        }
        int[] dp = new int[n];
        dp[0] = nums[0]; //at this instance , u only have one house if u rob you'll get max amount
        dp[1] = Math.max(nums[0] , nums[1] + 0); //max of no choose , choose 
        for(int i = 2 ; i < n ; i++){
            dp[i] = Math.max(dp[i-1] , nums[i] + dp[i-2]);
        }
        return dp[n-1];
        
    }
}