//time complexity-O(n)
//space complexity-O(n);
//passed all the test cases
//the approach is to pick and not pick non adjacent houses 
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        dp[0] = nums[0];
        if (n == 1)
            return nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            int notrob = dp[i - 1];
            int rob = nums[i] + dp[i - 2];
            dp[i] = Math.max(rob, notrob);
        }
        return dp[n - 1];
    }
}