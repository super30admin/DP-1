# Time Complexity = O(N)
# Space Complexity = O(N)
#
# Yes it ran on Leetcode.

class Solution(object):
    def rob(self, nums):
        if len(nums) == 0:
            return 0
        dp = [[0 for i in range(2)] for j in range(len(nums))]

        dp[0][0] = 0
        dp[0][1] = nums[0]

        for i in range(1, len(nums)):
            dp[i][0] = max(dp[i - 1][0], dp[i - 1][1])
            dp[i][1] = nums[i] + dp[i - 1][0]

        return max(dp[len(nums) - 1][0], dp[len(nums) - 1][1])