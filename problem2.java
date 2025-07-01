// Time Complexity: O(n)
// Space Complexity: O(n)

// Memoizing the max money robbed starting from the end. We keep checking arr[i] + arr[i+1] & arr[i] + arr[i+2], whichever is maximum we use that and move on


class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        if (nums.length == 1) return nums[0];

        int dp[] = new int[nums.length];

        for (int i=nums.length-1; i>=0; i--) {
            if (i+3 < nums.length) {
                dp[i] = Math.max(nums[i] + dp[i+2], nums[i] + dp[i+3]);
            } else if (i+2 < nums.length) {
                dp[i] = nums[i] + dp[i+2];
            } else {
                dp[i] = nums[i];
            } 
        }
        return Math.max(dp[0], dp[1]);
    }
}
