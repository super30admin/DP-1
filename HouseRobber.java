class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i=1; i<nums.length; i++)
        {
            dp[i+1] = Math.max (dp[i] , dp[i-1] + nums[i]);
        }
        return dp[nums.length];
    }
}
Time Complexity : O(N) where N is the number of houses.
Space Complexity : O(1)
Leetcode Working : Yes
Reference : https://www.hackerearth.com/practice/algorithms/dynamic-programming/introduction-to-dynamic-programming-1/tutorial/