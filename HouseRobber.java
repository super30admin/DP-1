// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
 We can take a dp 1-D array to to compute the value at index i by considering the max of i - 1 and i -2
 indices by relating choose and no choose cases. If we do it recursively, is 2^n TC and contains lot of
 repetitive subproblems. So we optimize it with DP. We can also further optimize by removing dp array and
 use only 2 variables like current and previous as we are not relying on other values excepr i-1, i-2.
 */
class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        int m = nums.length;
        //Approach 1
        // int[] dp = new int[m + 1];

        // dp[0] = nums[0];
        // dp[1] = Math.max(nums[0], nums[1]);

        // for(int i = 2 ; i < m ; i++) {
        //     dp[i] = Math.max(dp[i - 1] , nums[i] + dp[i - 2]);
        // }

        // return dp[m - 1];

        //Approach 2 for optimized space
        int prev = nums[0];
        int curr = Math.max(nums[0], nums[1]);

        for(int i = 2 ; i < m ; i++)  {
            int temp = curr;
            curr = Math.max(temp , nums[i] + prev);
            prev = temp;
        }
        return curr;

    }
}