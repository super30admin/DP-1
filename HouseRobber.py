# Time Complexity : O(n) 
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def rob(self, nums: List[int]) -> int:
        #We initialize a 1d array as the no.of constants is 1
        dp = [0]*len(nums)
        if len(nums)==1:
            return nums[-1]
        else:
            dp[0] = nums[0]
            dp[1] = max(nums[0],nums[1])
            for i in range(2,len(nums)):
                dp[i] = max(dp[i-1],dp[i-2]+nums[i])
            return dp[-1] 