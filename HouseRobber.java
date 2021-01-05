//TC: O(N) - N is the no. of elements in nums array
//SC: O(N)
// Did it run successfully on LeetCode? : Yes
class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if ( nums.length == 1) 
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);
        int[] dp = new int[nums.length+1];
        dp[1] = nums[0];
        for (int i = 2; i < dp.length; i++)
        {
            dp[i] = Math.max(dp[i-2] + nums[i-1], dp[i-1]);
        }
        return dp[dp.length-1];
    }
}
