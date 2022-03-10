 
    # 198. House Robber

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
        if not nums:
            return 0
        if len(nums)<3:
            return max(nums)        
        
        dp = [0] * len(nums)
        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])
        
        for i in range(2, len(nums)):
            # Decide if to keep the next house number or not
            dp[i] = max(nums[i]+dp[i-2], dp[i-1])
        
        
        return dp[-1]
