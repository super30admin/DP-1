"""
Problem: House Robber
Leetcode: https://leetcode.com/problems/house-robber/
Solution: Use Dynamic programming - bottom up approach
Time Complexity: O(n)
Space Complexity: O(n)
"""


class Solution:
    def rob(self, nums):
        if len(nums) == 0 or nums is None:
            return 0

        if len(nums) == 1:
            return nums[0]

        # Define an array to store max number of houses that can be robbed at index i for max profit
        dp = [None] * len(nums)
        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])

        for i in range(2,len(nums)):
            dp[i] = max(dp[i-1], dp[i-2] + nums[i])

        return dp[len(nums)-1]


# Test cases -
# nums = [2,7,9,3,1]
nums = [1,2,3,1]
obj = Solution()
print(obj.rob(nums))