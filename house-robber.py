# We use dynamic programming to find the maximum amount of money that can be robbed.
# We initialize a dp array where dp[i] represents the maximum amount of money that can be robbed up to house i, starting with dp[0] = nums[0] and dp[1] = max(nums[0], nums[1]).
# For each house, we update the dp array by taking the maximum of the current value and the value of the amount minus the house value plus the amount of money in the previous house.

# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def rob(self, nums: List[int]) -> int:
        if not nums:
            return 0
        if len(nums) == 1:
            return nums[0]
        prev2 = nums[0]
        prev1 = max(nums[0], nums[1])
        for i in range(2, len(nums)):
            curr = max(prev1, prev2 + nums[i])
            prev2 = prev1
            prev1 = curr
        return prev1
        