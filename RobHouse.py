from typing import List
class Solution:
    def rob(self, nums: List[int]) -> int:
        dp = [0 for i in range(len(nums)+1)]
        dp[1] = nums[0]
        for i in range(2,len(nums)+1):
            dp[i] = max(nums[i-1]+dp[i-2], dp[i-1])
        return max(dp[-1], dp[-2])