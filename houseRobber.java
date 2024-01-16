// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach

public class houseRobber {

    // Using two variables
    private int helper(int[] nums) {

        int n = nums.length;

        if (n == 1) {
            return nums[n - 1];
        }

        if (n == 2) {
            return Math.max(nums[n - 1], nums[n - 2]);
        }

        int prev = nums[n - 1];
        int curr = Math.max(nums[n - 1], nums[n - 2]);
        for (int i = n - 2; i > 0; i--) {
            int temp = curr;
            curr = Math.max(curr, nums[i - 1] + prev);
            prev = temp;
        }

        return curr;
    }

    public int rob(int[] nums) {
        return helper(nums);
    }

    // O(N) solution space O(N)
    // private int helper(int[] nums) {

    // int n = nums.length;
    // int[] dp = new int[n+1];

    // if(n == 1) {
    // dp[n-1] = nums[n-1];
    // return dp[n-1];
    // }

    // if(n == 2) {
    // dp[n-2] = Math.max(nums[n-1],nums[n-2]);
    // return dp[n-2];
    // }

    // dp[n] = nums[n-1];
    // dp[n-1] = Math.max(nums[n-1],nums[n-2]);
    // for(int i=n-2;i>0;i--) {
    // // dp[i] = nums[i-1];
    // // for(int j=i+2;j<=n;j++) {
    // dp[i] = Math.max(dp[i+1],nums[i-1] + dp[i+2]);
    // // }
    // }

    // dp[0] = Math.max(dp[1],dp[2]);
    // return dp[0];
    // }

    // Recursive solution O(n*2^(n))

    // private void helper(int[] nums, int idx,int sum) {

    // if(idx >= nums.length) {
    // res = Math.max(res,sum);
    // System.out.println(sum);
    // return;
    // }

    // for(int i=idx;i<nums.length;i++) {
    // sum += nums[i];
    // helper(nums,i+2,sum);
    // sum -= nums[i];
    // }
    // }
}
