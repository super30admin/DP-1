# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

class Solution:
    def rob(self, nums: List[int]) -> int:
        dp = [0 for x in range(len(nums))]
        dp[0] = nums[0]
        for i in range(1, len(nums)):
            if i-2 < 0:
                dp[i] = max(nums[i], dp[i-1])
            else:
                select = nums[i] + dp[i-2]
                notSelect= dp[i-1]
                dp[i] = max(select, notSelect)
        return dp[-1]