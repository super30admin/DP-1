## Problem2 (https://leetcode.com/problems/house-robber/)

# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution(object):
    def rob(self, nums):
            """
            :type nums: List[int]
            :rtype: int
            """

            if nums == None or len(nums) == 0:
                return 0

            dp = [[0 for i in range(2)] for j in range(len(nums))]

            dp[0][1] = nums[0]

            for i in range(1, len(dp)):
                dp[i][0] = max(dp[i - 1][0], dp[i - 1][1])
                dp[i][1] = nums[i] + dp[i - 1][0]

            return max(dp[len(dp) - 1][0], dp[len(dp) - 1][1])

nums = [2, 7, 9, 3, 1]
print(Solution().rob(nums))