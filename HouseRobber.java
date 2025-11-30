// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int rob(int[] nums) {
        // 1D array
        // if(nums.length == 1) return nums[0];

        // int dp[] = new int[nums.length];
        // dp[0] = nums[0];
        // dp[1] = Math.max(nums[0], nums[1]);
        // for(int i = 2; i < nums.length; i++)
        // {
        //     dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
        // }
        // return dp[nums.length - 1];

        // two variables
        if(nums.length == 1) return nums[0];
        int prev = nums[0];
        int curr = Math.max(nums[0], nums[1]);

        for(int i = 2; i < nums.length; i++)
        {
            int temp = Math.max(curr, prev+nums[i]);
            prev = curr;
            curr = temp;
        }

        return curr;
    }
}