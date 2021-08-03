"""
Time Complexity : O(2^n)
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        # If only one house then no option
        if len(nums) == 1:
            return nums[0]
        dp = [[0 for i in range(2)] for i in range(len(nums))]
        dp[0][1] = nums[0]
        # Creating a skip and take table
        for i in range(len(nums)):
            dp[i][0] = max(dp[i - 1][0], dp[i - 1][1])
            dp[i][1] = dp[i - 1][0] + nums[i]
        return max(dp[len(dp) - 1][0], dp[len(dp) - 1][1])