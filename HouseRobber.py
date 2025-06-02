# Implementation Thought: Use dynamic programming where dp[i] represents the max amount up to house i, choosing to rob or skip.
# Time Complexity: O(n), where n = len(nums), 
# Space Complexity: O(n), due to the dp array of size n.

from typing import List

class Solution:
    def rob(self, nums: List[int]) -> int:
        if not nums:
            return 0

        if len(nums) == 1:
            return nums[0]
        
        dp = [0] * len(nums)
        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])

        for i in range(2, len(nums)):
            dp[i] = max(dp[i - 2] + nums[i], dp[i - 1])
        
        return dp[-1]
