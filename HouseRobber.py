# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Using a dp array we will maintain which alternate house combination will give us the maximum money.

from typing import List
class Solution():    
    def rob(self, nums: List[int]) -> int: 
        if not nums:
            return -1
        if len(nums)<3:
            return max(nums)
        dp=[0]*len(nums)
        dp[0]=nums[0]
        dp[1]=max(nums[0],nums[1])
        
        for i in range(2,len(nums)):
            dp[i]=max(nums[i]+dp[i-2],dp[i-1])
        return max(dp)

obj=Solution()
obj.rob([2,7,9,3,1])