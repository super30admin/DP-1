/*
 * Time Complexity : O(n)
 * Space Complexity : O(n)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
*/


// ! Recursive with memoization solution

#include <vector>

/*
class Solution {
    int helper(int idx, std::vector<int>& nums, std::vector<int>& memo) {
        ? base case
        if (idx >= nums.size())
            return 0;

        ? check memo table
        if (memo[idx] != -1)
            return memo[idx];

        ? logic
        ? Choose: rob
        int rob = nums[idx] + helper(idx + 2, nums, memo);
        ? Don't Choose: don't rob
        int dont_rob = helper(idx + 1, nums, memo);

        ? store
        memo[idx] = std::max(rob, dont_rob);
        return memo[idx];
    }
public:
    int rob(std::vector<int>& nums) {
        std::vector<int> memo(nums.size(), -1);
        return helper(0, nums, memo);
    }
};
*/

// ! Itereative tablulation DP Solution (Bottom - up approach)

class Solution {
public:
    int rob(std::vector<int>& nums) {

        int n = nums.size();
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        // initialization
        std::vector<int> dp(n, 0);
        dp[0] = nums[0];
        dp[1] = std::max(nums[0], nums[1]);

        // iteration
        for (int i = 2; i < n; i++) {
            dp[i] = std::max(nums[i] + dp[i - 2], dp[i - 1]);
        }

        return dp[n -1];
    }
};