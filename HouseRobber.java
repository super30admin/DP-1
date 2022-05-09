class Solution {
    /**
     * Each place 2 options, choose to rob or not choose. First 2 values we store in dp array.
     * for further usecased we can use dp array as i-1 and i-2
     * Time: O(n)
     * Space O(n)
     */

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]); //max(Notchoose,choose)
        }
        return dp[dp.length - 1];
    }
}
