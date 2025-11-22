# Time Complexity :O(n)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this :no


# Your code here along with comments explaining your approach
# I used a DP array where each index stores the maximum money that can be robbed up to that house.
# For every house, I choose the best option between skipping it or robbing it plus the value from two houses before.
# Finally, I return the last DP value, which represents the maximum amount that can be robbed without triggering the alarm.

class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums)==1:
            return nums[0]
        n = len(nums)
        dp = [0]*(n)
        dp[0] = nums[0]
        dp[1] = max(dp[0],nums[1])
        for i in range(2,n):
            dp[i] = max(dp[i-1],nums[i]+dp[i-2])
        return dp[n-1]