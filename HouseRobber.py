"""
Time Complexity : O(n)
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this: none
"""

class Solution:
    def rob(self, nums):
        size = len(nums)
        
        # edge case
        if size == 0:
            return 0
        # cases to make code a bit faster
        if size == 1:
            return nums[0]
        
        if size == 2:
            return max(nums[0], nums[1])
        
        # main logic - if size is greater than 2
        dp = [0] * size
        
        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])
        
        for i in range(2, size):
            dp[i] = max(nums[i] + dp[i-2], dp[i-1])
            
        return dp[-1]
    
s = Solution()    
print(s.rob([1,2,3,1]))