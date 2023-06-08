# Time Complexity : O(n) where n is the number of houses
# Space Complexity : O(n) where n is the number of houses
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

#  In this probem, we just need to maximize the profit from robbing houses.
# In the DP solution, at every step, we have 2 options, to rob the previous house and hence skip this one,
# or to rob this house and use the max profit from 2 houses before.
class Solution:
    def rob(self, nums: List[int]) -> int:
        if not nums:
            return 0
        if len(nums) == 1:
            return nums[0]
        if len(nums) == 2:
            return max(nums[1], nums[0])
        dp = [0 for _ in range(len(nums))]
        dp[0] = nums[0]
        dp[1] = max(nums[1], nums[0])
        
        for i in range(2, len(nums)):
            dp[i] = max(dp[i], dp[i-1], dp[i-2] + nums[i])

        return dp[len(nums)-1]
