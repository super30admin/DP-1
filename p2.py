# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this :


#  Your code here along with comments explaining your approach


class Solution:
    def rob(self, nums: List[int]) -> int:

        if len(nums) == 0:
            return 0

        elif len(nums) < 2:
            return max(nums)
        dp = [0 for i in range(len(nums))]

        dp[0] = nums[0]

        dp[1] = max(nums[:2])

        for i in range(2, len(nums)):
            dp[i] = max(dp[i - 1], nums[i] + dp[i - 2])

        return dp[-1]
