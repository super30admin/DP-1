// Time complexity: O(N), where N is the length of nums array. 
// Space complexity: O(N).

class Solution2 {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        int n = nums.length;
        //handling the edge cases
        if(n == 1) return nums[0]; 
        
        int[] dp = new int[n];
        //if there is only one house, the maximum amount of money the robber can rob is nums[0]. 
        dp[0] = nums[0];
        // if there are two house, the maximum amount of money the robber can rob is the maximum of nums[0] and nums[1]. 
        dp[1] = Math.max(nums[0], nums[1]); 
        for (int i = 2; i < n; i++) {
            // updating the dp with the maximum amount of money the robber can rob. 
            dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
        }
        return dp[n-1]; 
    }
}
