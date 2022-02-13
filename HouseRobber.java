// Time Complexity O(n)
// Space Complexity O(n)
class Solution {
    public int rob(int[] nums) {
        int [] dp = new int[nums.length + 2];
        
        for(int i = nums.length-1;i>=0;i--){
            int nc = dp[i+1];
            int c = nums[i] + dp[i+2];
            dp[i] = Math.max(nc, c);
        }
        
        return dp[0];
    }
}
