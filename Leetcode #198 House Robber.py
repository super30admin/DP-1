# Time Complexity: O(n) where n is the length of the nums
# Space Complexity: O(n)

from tkinter import N


class Solution:
    def rob(nums):
        if len(nums) == 0 or nums is None:
            return 0
        
        n = len(nums)
        dp = [[0]*(2) for i in range(n)]

        dp[0][1] = nums[0]
        for i in range(1, n):
            # do not chose
            dp[i][0] = max(dp[i - 1][0], dp[i - 1][1])
            # choose
            dp[i][1] = dp[i - 1][0] + nums[i]


        return max(dp[n-1][0], dp[n-1][1])
