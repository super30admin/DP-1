// TC: O(n), SC:O(1)
class Solution {
    public int rob(int[] nums) {
        //null case
        if(nums== null || nums.length==0) return 0;
        int n= nums.length;
        
        if(n<=1) return nums[0];
        int dp[]= new int[n+1];
        dp[1]=nums[0];
        
        for(int i=2; i<n+1; i++){
            dp[i]= Math.max(dp[i-1], nums[i-1]+dp[i-2]);
        }
        return dp[n];
    }
}
