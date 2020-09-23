# Time Complexity : O(N)
# Space Complexity : O(N)

# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : no

class Solution:
    def rob(self, nums):
        if len(nums)==1:
            return nums[0]
        Dp = [0]*len(nums)
        Dp[0]= nums[0]
        Dp[1] = max(nums[0],nums[1])
        for i in range(2,len(nums)):
            Dp[i] = max(nums[i]+Dp[i-2],Dp[i-1])
        return max(Dp)