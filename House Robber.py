# We use DP to keep track of the max money we can rob up to each house.
# For each house, choose max of (rob current + dp[i-2]) vs (skip current and take dp[i-1]).
# This ensures no two adjacent houses are robbed while maximizing profit.

class Solution(object):
    def rob(self, nums):
        n = len(nums)
        if n == 0:
            return 0
        if n == 1:
            return nums[0]

        dp = [0] * n
        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])

        for i in range(2, n):
            dp[i] = max(dp[i - 1], nums[i] + dp[i - 2])

        return dp[-1]
