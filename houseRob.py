# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach: Use bottom-up DP. For each house, choose the maximum between
# robbing it (nums[i] + dp[i+2]) or skipping it (dp[i+1]).
# dp[i] stores the maximum money that can be robbed starting from house i.
# The final answer is dp[0].


class Solution:
    def rob(self, nums: List[int]) -> int:
        dp = [0 for i in range(len(nums) + 2)]
        for i in range(len(nums) - 1,-1,-1):
            take     = nums[i] + dp[i + 2]
            no_take  = dp[i + 1]
            dp[i] = max(take,no_take)
        return dp[0]