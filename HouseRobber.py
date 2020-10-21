#Time Complexity : O(n) where n is the length of input array i.e. number of houses
#Space Complexity : O(n) where n is the length of input array i.e. number of houses
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class Solution:
    def rob(self, nums: List[int]) -> int:
        if not nums:
            return 0

        dp = [0 for _ in range(len(nums)+1)]

        dp[1] = nums[0]

        for i in range(2, len(nums)+1):
            dp[i] = max(dp[i-1], dp[i-2]+nums[i-1])

        return dp[len(nums)]
