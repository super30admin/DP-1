# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : dp[i] is the max amount robbed.
# For each house, update the array by either robbing it or skipping it.

class Solution:
    def rob(self, nums: List[int]) -> int:
        if not nums:
            return 0

        n = len(nums)
        maxRobbedAmt = [None] * (n + 1)

        maxRobbedAmt[n], maxRobbedAmt[n-1] = 0, nums[n-1]

        for i in range(n-2, -1, -1):
            maxRobbedAmt[i] = max(maxRobbedAmt[i+1], maxRobbedAmt[i+2] + nums[i])

        return maxRobbedAmt[0]