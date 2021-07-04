# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def rob(self, nums: [int]):
        # edge case
        if not nums or len(nums) == 0:
            return 0
        n = len(nums)
        if n < 2:
            return nums[0]  # rob the first house/only house
        dp = [0] * n
        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])
        for i in range(2, n):
            dp[i] = max((dp[i - 1]), (dp[i - 2] + nums[i]))  # max amount collected
        return dp[-1]


r = Solution()
nums = [2, 7, 9, 3, 1]
print("Total amount that can be robbed is", r.rob(nums))
nums = [1, 2, 3, 1]
print("Total amount that can be robbed is", r.rob(nums))
nums = [5]
print("Total amount that can be robbed is", r.rob(nums))
